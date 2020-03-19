package io.b2chat.bots.niviconsultas.bot.bizlogic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vertical.bot.bizlogic.IBotBizLogicStrategy;
import com.vertical.bot.domain.Bot;
import com.vertical.bot.domain.MessagingAccount;
import com.vertical.bot.util.BeansProvider;
import com.vertical.messagingservices.model.Agent;
import com.vertical.messagingservices.model.IncomingMessage;
import com.vertical.messagingservices.model.IncomingTextMessage;
import com.vertical.messagingservices.model.MessageSending;
import com.vertical.messagingservices.model.MessageSendingBase;

import io.b2chat.bots.niviconsultas.BotLogger;
import io.b2chat.bots.niviconsultas.Context;
import io.b2chat.bots.niviconsultas.state.BootstrapState;
import io.b2chat.bots.niviconsultas.state.ForwardToChatState;
import io.b2chat.bots.util.interpreters.MapiModelInterpreter;

@Component("BotNiviConsultas")
@Scope("prototype")
public class BizLogic implements IBotBizLogicStrategy{
	
	private static final long serialVersionUID = -794395163393891566L;
	
	private Context context;
	
	public BizLogic() {
		BotLogger.debug(BizLogic.class, "BizLogic");
		this.setContext(new Context());
	}

	@Override
	public void initialize(Bot hostedInBot, MessagingAccount botMsgAccount, String startedByMsgAccountId) {
		BotLogger.debug(BizLogic.class, "BizLogic.initialize");
	}
	
	@Override
	public List<MessageSendingBase> handleIncomingBotUserMsg(MessagingAccount sourceAccount, IncomingMessage receivedMsg) {
		BotLogger.debug(BizLogic.class, "BizLogic.handleIncomingBotUserMsg");
		BotLogger.debug(BizLogic.class, String.format("BizLogic.handleIncomingBotUserMsg: Got message {} from {}", receivedMsg, sourceAccount));
		IncomingTextMessage textMessage = MapiModelInterpreter.asTextMessage(receivedMsg);
		List<MessageSendingBase> messages = this.getContext().processMessage(sourceAccount, textMessage.getMessage(), textMessage.getFrom());
		return this.processMessages(messages, sourceAccount, receivedMsg.getFrom());
	}
	
	@Override
	public List<MessageSendingBase> handleIncomingAgentChatMsg(MessagingAccount sourceAccount, IncomingMessage receivedMsg) {
		BotLogger.debug(BizLogic.class, "BizLogic.handleIncomingAgentChatMsg");
		return null;
	}
	
	@Override
	public List<MessageSendingBase> handleAgentClosedChat(MessagingAccount sourceAccount, String userId){
		BotLogger.debug(BizLogic.class, "BizLogic.handleAgentClosedChat");
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		MessageSending message = new MessageSending(BeansProvider.getBean(MessageSource.class).getMessage("agent.closedchat", null, null));
		messages.add(message);
		this.getContext().setState(this.getContext().getPreviousState());
		messages.addAll(this.getContext().getState().receiveMessage(this.getContext(), sourceAccount, null));
		return this.processMessages(messages, sourceAccount, userId);
	}
	
	@Override
	public List<MessageSendingBase> handleAwaitingAgentPickup(MessagingAccount sourceAccount, String userId) {
		BotLogger.debug(BizLogic.class, "BizLogic.handleAwaitingAgentPickup");
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		MessageSending message = new MessageSending(BeansProvider.getBean(MessageSource.class).getMessage("agent.awaitingtopickup", null, null));
		messages.add(message);
		return this.processMessages(messages, sourceAccount, userId);
	}
	
	@Override
	public List<MessageSendingBase> handleNoAgentsAvailable(MessagingAccount botAccount, String userId){
		BotLogger.debug(BizLogic.class, "BizLogic.handleNoAgentsAvailable");
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		MessageSending message = new MessageSending(BeansProvider.getBean(MessageSource.class).getMessage("agent.unavailable", null, null));
		messages.add(message);
		this.getContext().setState(new BootstrapState());
		messages.addAll(this.getContext().getState().receiveMessage(this.getContext(), botAccount, null));
		return this.processMessages(messages, botAccount, userId);
	}
	
	@Override
	public List<MessageSendingBase> handleAgentRequestedStartChat(MessagingAccount sourceAccount, Agent agent, String userId) {
		BotLogger.debug(BizLogic.class, "BizLogic.handleAgentRequestedStartChat");
		this.getContext().setState(new ForwardToChatState());
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		MessageSending message = new MessageSending(BeansProvider.getBean(MessageSource.class).getMessage("agent.wantstotalktouser", new Object[] { agent.getName() }, null));
		messages.add(message);
		return this.processMessages(messages, sourceAccount, userId);
	}
	
	@Override
	public List<MessageSendingBase> handleError(MessagingAccount botAccount, String userId, Exception error){
		BotLogger.debug(BizLogic.class, "BizLogic.handleError");
	    return null;
	}
	
	@Override
	public boolean isForwardingBotUserMsgsToChat() {
		BotLogger.debug(BizLogic.class, "BizLogic.isForwardingBotUserMsgsToChat");
		return this.getContext().getState() instanceof ForwardToChatState;
	}
	
	@Override
	public Boolean inhibitForwardingToAgentChat() {
		BotLogger.debug(BizLogic.class, "BizLogic.inhibitForwardingToAgentChat");
		return this.getContext().getInhibitForwarding();
	}
	
	@Override
	public Boolean createChatWithNoAgentsAvailable() {
		BotLogger.debug(BizLogic.class, "BizLogic.createChatWithNoAgentsAvailable");
		return false;
	}
	
	@Override
	public void initTransientProperties() {
		BotLogger.debug(BizLogic.class, "BizLogic.initTransientProperties");
	}
	
	@Override
	public void setAsynMessageSender(Consumer<MessageSendingBase> f) {
		BotLogger.debug(BizLogic.class, "BizLogic.setAsynMessageSender");
		return;
	}
	
	@Override
	public void setAsynTypingStatus(Consumer<MessageSendingBase> f){
		BotLogger.debug(BizLogic.class, "BizLogic.setAsynTypingStatus");
	    return;
	}
	
	private List<MessageSendingBase> processMessages(List<MessageSendingBase> messages, MessagingAccount account, String to){
		if (messages != null && !messages.isEmpty() && messages.size() > 0) 
			for (MessageSendingBase message : messages) {
				message.setProvider(account.getProvider().getProviderCode());
				message.setFrom(account.getName());
				message.setTo(to);
			}
		return messages;
	}
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
}
