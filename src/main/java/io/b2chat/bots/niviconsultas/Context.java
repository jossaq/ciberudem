package io.b2chat.bots.niviconsultas;

import java.io.Serializable;
import java.util.List;

import com.vertical.bot.domain.MessagingAccount;
import com.vertical.bot.domain.MessagingProvider;
import com.vertical.messagingservices.model.MessageSendingBase;

import io.b2chat.bots.niviconsultas.domain.User;
import io.b2chat.bots.niviconsultas.state.BootstrapState;
import io.b2chat.bots.niviconsultas.state.ForwardToChatState;
import io.b2chat.bots.niviconsultas.state.IState;
import io.b2chat.bots.niviconsultas.state.OrderFollowUpState;
import io.b2chat.bots.niviconsultas.state.SearchCampaignState;
import io.b2chat.bots.niviconsultas.state.UserRegistrationState;
import io.b2chat.bots.niviconsultas.templates.IRenderTemplate;
import io.b2chat.bots.niviconsultas.templates.RenderTemplateFB;
import io.b2chat.bots.niviconsultas.templates.RenderTemplateTG;
import io.b2chat.bots.niviconsultas.templates.RenderTemplateWA;

public class Context implements Serializable{
	
	private static final long serialVersionUID = -8844100861818332397L;
	
	private IState state;
	private IState previousState;
	
	private boolean inhibitForwarding;
	
	private String messagingUserId;
	private MessagingProvider messagingProvider;
	private String messagingName;
	
	private transient IRenderTemplate renderTemplate;
	
	private User user;
	
	public Context() {
		BotLogger.debug(Context.class, "Context.constructor");
		BotLogger.debug(Context.class, "Context.constructor: Set initial state as BootstrapState");
		this.setState(new BootstrapState());
	}
	
	private void setMessagingAttributes(String userId, MessagingAccount messaging) {
		BotLogger.debug(Context.class, "Context.setAccountAttributes");
		this.setMessagingUserId(userId);
		this.setMessagingProvider(messaging.getProvider());
		this.setMessagingName(messaging.getName());
	}
	
	private void checkInhibitForwarding(){
		if (this.getState() instanceof ForwardToChatState)
			this.inhibitForwarding = false;
	}
	
	private boolean checkForIncomingCommands(String message) {
		switch (message.toString().trim()) {
			case "/reset": this.setState(new BootstrapState()); break;
			case "/chat": this.setState(new ForwardToChatState()); this.setInhibitForwarding(true); break;
			case "/searchcampaign": this.setState(new SearchCampaignState()); break;
			case "/orderfollowup": this.setState(new OrderFollowUpState()); break;
			case "/requestcatalog": this.setState(new UserRegistrationState()); break;
			default: return false;
		}
		return true;
	}
	
	public List<MessageSendingBase> processMessage(MessagingAccount fromBotAccount, String message, String userId) {
		BotLogger.debug(Context.class, "Context.processMessage");
		BotLogger.debug(Context.class, String.format("Context.processMessage: Got message {}", message));
		this.setMessagingAttributes(userId, fromBotAccount);
		this.checkInhibitForwarding();
		if (this.checkForIncomingCommands(message)) message = null;
		return this.getState().receiveMessage(this, fromBotAccount, message);
	}
	
	public void setState(IState state) {
		this.setPreviousState(this.state);
		this.state = state;
	}
	
	public IState getState() {
		return this.state;
	}

	public boolean getInhibitForwarding() {
		return inhibitForwarding;
	}

	public void setInhibitForwarding(boolean inhibitForwarding) {
		this.inhibitForwarding = inhibitForwarding;
	}

	public String getMessagingUserId() {
		return messagingUserId;
	}

	public void setMessagingUserId(String messagingUserId) {
		this.messagingUserId = messagingUserId;
	}

	public MessagingProvider getMessagingProvider() {
		return messagingProvider;
	}

	public void setMessagingProvider(MessagingProvider messagingProvider) {
		this.messagingProvider = messagingProvider;
	}

	public String getMessagingName() {
		return messagingName;
	}

	public void setMessagingName(String messagingName) {
		this.messagingName = messagingName;
	}

	public IState getPreviousState() {
		return previousState;
	}

	public void setPreviousState(IState previousState) {
		this.previousState = previousState;
	}

	public IRenderTemplate getRenderTemplate() {
		BotLogger.debug(Context.class, "Context.getRenderTemplate");
		if (this.renderTemplate == null) {
			if (this.getMessagingProvider().equals(MessagingProvider.FACEBOOK)) this.setRenderTemplate(new RenderTemplateFB()); 
			if (this.getMessagingProvider().equals(MessagingProvider.TELEGRAM)) this.setRenderTemplate(new RenderTemplateTG());
			if (this.getMessagingProvider().equals(MessagingProvider.WHATSAPP)) this.setRenderTemplate(new RenderTemplateWA());
		}
		return renderTemplate;
	}

	public void setRenderTemplate(IRenderTemplate renderTemplate) {
		this.renderTemplate = renderTemplate;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}