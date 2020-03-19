package io.b2chat.bots.niviconsultas.state;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.vertical.bot.domain.MessagingAccount;
import com.vertical.messagingservices.model.MessageSendingBase;

import io.b2chat.bots.niviconsultas.Context;
import io.b2chat.bots.niviconsultas.domain.User;
import io.b2chat.bots.niviconsultas.services.UserService;

public class BootstrapState extends AState {

	private static final long serialVersionUID = -9119216291020950432L;
	
	public transient static final int WELCOMING = 0;
	public transient static final int USER_ID = 1;
	public transient static final int USER_LOGGEDIN = 2;
	
	public BootstrapState() {
		this.setStep(WELCOMING);
	}

	@Override
	public List<MessageSendingBase> receiveMessage(Context context, MessagingAccount messaging, String message) {
		switch (this.getStep()) {
			case WELCOMING: return this.welcoming(context, message);
			case USER_ID: return this.userId(context, message);
			case USER_LOGGEDIN: return this.userLoggedIn(context, context.getUser());
			default: return null;
		}
	}
	
	private List<MessageSendingBase> welcoming(Context context, String message){
		
		if (context.getUser() != null)
			return context.getRenderTemplate().bootstrapLoggedUserMenu(context.getUser());
		
		if (message != null && message.equalsIgnoreCase("//userlogin")) {
			this.setStep(USER_ID);
			return this.userId(context, null);
		}
		return context.getRenderTemplate().bootstrapWelcoming();
	}
	
	 private List<MessageSendingBase> userId(Context context, String message){
		 
		 if (message != null) {
			 
			 if (message != null && message.equalsIgnoreCase("//askforidentification"))
				 return context.getRenderTemplate().bootstrapAskForUserIdentification();
			 
			 if (StringUtils.length(message) > 10 || !StringUtils.isNumeric(message))
					return context.getRenderTemplate().bootstrapAskForUserIdentificationWrongFormat();
			 
			 User user = new User();
			 user.setIdentification(message);
			 user = new UserService().authenticate(user);
			 if (user.getId() == null)
				 return context.getRenderTemplate().bootstrapAskForUserIdentificationFailed();
			 
			 context.setUser(user);
			 
			 this.setStep(USER_LOGGEDIN);
			 return this.userLoggedIn(context, user);
		 }
		 return context.getRenderTemplate().bootstrapAskForUserIdentification();
	 }
	 
	 private List<MessageSendingBase> userLoggedIn(Context context, User user){
		 return context.getRenderTemplate().bootstrapLoggedUserMenu(user);
	 }

}
