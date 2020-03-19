package io.b2chat.bots.niviconsultas.templates;

import java.util.List;

import com.vertical.messagingservices.model.MessageSendingBase;

import io.b2chat.bots.niviconsultas.domain.Campaign;
import io.b2chat.bots.niviconsultas.domain.Order;
import io.b2chat.bots.niviconsultas.domain.User;

public interface IRenderTemplate {
	
	List<MessageSendingBase> bootstrapWelcoming();
	List<MessageSendingBase> bootstrapLoggedUserMenu(User user);
	List<MessageSendingBase> bootstrapAskForUserIdentification();
	List<MessageSendingBase> bootstrapAskForUserIdentificationWrongFormat();
	List<MessageSendingBase> bootstrapAskForUserIdentificationFailed();
	
	List<MessageSendingBase> searchCampaignMenu();
	List<MessageSendingBase> searchCampaignDetail(Campaign campaign);
	List<MessageSendingBase> searchCampaignFailed();
	
	List<MessageSendingBase> orderFollowUpMenu();
	List<MessageSendingBase> orderFollowUpOrderIdWrongFormat();
	List<MessageSendingBase> orderFollowUpOrderIdFailed();
	List<MessageSendingBase> orderFollowUpOrderDetailNoGuide(Order order, User user);
	List<MessageSendingBase> orderFollowUpOrderDetailGuide(Order order, User user);
	
	List<MessageSendingBase> userRegistrationInstructions();
	List<MessageSendingBase> userRegistrationAskForFullname();
	List<MessageSendingBase> userRegistrationAskForFullnameWrongFormat();
	List<MessageSendingBase> userRegistrationAskForEmail();
	List<MessageSendingBase> userRegistrationAskForEmailWrongFormat();
	List<MessageSendingBase> userRegistrationAskForCellphone();
	List<MessageSendingBase> userRegistrationAskForCellphoneWrongFormat();
	List<MessageSendingBase> userRegistrationSuccess();
	
}