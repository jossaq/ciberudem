package io.b2chat.bots.niviconsultas.state;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import com.vertical.bot.domain.MessagingAccount;
import com.vertical.messagingservices.model.MessageSendingBase;

import io.b2chat.bots.niviconsultas.Context;
import io.b2chat.bots.niviconsultas.domain.User;
import io.b2chat.bots.niviconsultas.services.UserService;

public class UserRegistrationState extends AState {

	private static final long serialVersionUID = 1349778918166930837L;

	public transient static final int INSTRUCTIONS = 0;
	public transient static final int USER_FULLNAME = 1;
	public transient static final int USER_EMAIL = 2;
	public transient static final int USER_CELLPHONE = 3;
	public transient static final int USER_REGISTERED = 4;
	
	public UserRegistrationState() {
		this.setStep(INSTRUCTIONS);
	}
	
	@Override
	public List<MessageSendingBase> receiveMessage(Context context, MessagingAccount messaging, String message) {
		switch (this.getStep()) {
			case INSTRUCTIONS: return this.instructions(context, message);
			case USER_FULLNAME: return this.userFullname(context, message);
			case USER_EMAIL: return this.userEmail(context, message);
			case USER_CELLPHONE: return this.userCellphone(context, message);
			case USER_REGISTERED: return this.userRegistered(context, message);
			default: return null;
		}
	}
	
	public List<MessageSendingBase> instructions(Context context, String message) {
		List<MessageSendingBase> messages = context.getRenderTemplate().userRegistrationInstructions();
		this.setStep(USER_FULLNAME);
		messages.addAll(this.userFullname(context, null));
		return messages;
	}
	
	public List<MessageSendingBase> userFullname(Context context, String message) {
		
		if (message != null) {

			if (StringUtils.length(message) < 5)
				return context.getRenderTemplate().userRegistrationAskForFullnameWrongFormat();
			
			User user = new User();
			user.setFullname(message);
			context.setUser(user);
			
			this.setStep(UserRegistrationState.USER_EMAIL);
			return this.userEmail(context, null);
		}
		return context.getRenderTemplate().userRegistrationAskForFullname();
	}
	
	public List<MessageSendingBase> userEmail(Context context, String message) {
		
		if (message != null) {
			
			if (StringUtils.length(message) < 5 || !EmailValidator.getInstance().isValid(message))
				return context.getRenderTemplate().userRegistrationAskForEmailWrongFormat();
				
			context.getUser().setEmail(message);
			this.setStep(USER_CELLPHONE);
			return this.userCellphone(context, null);
		}
		return context.getRenderTemplate().userRegistrationAskForEmail();
	}
		
	public List<MessageSendingBase> userCellphone(Context context, String message) {
		
		if (message != null) {
			
			if (StringUtils.length(message) < 10 || !StringUtils.isNumeric(message))
				return context.getRenderTemplate().userRegistrationAskForCellphoneWrongFormat();
				
			context.getUser().setCellphone(message);
			
			new UserService().saveForRegistration(context.getUser());
			
			this.setStep(USER_REGISTERED);
			return this.userRegistered(context, null);
		}
		return context.getRenderTemplate().userRegistrationAskForCellphone();
	}
	
	public List<MessageSendingBase> userRegistered(Context context, String message) {
		context.setUser(null);
		return context.getRenderTemplate().userRegistrationSuccess();
	}
	
}
