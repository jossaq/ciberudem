package io.b2chat.bots.niviconsultas.templates;

import java.util.List;

import com.vertical.messagingservices.model.MessageSending;
import com.vertical.messagingservices.model.MessageSendingBase;

import io.b2chat.bots.niviconsultas.domain.Campaign;
import io.b2chat.bots.niviconsultas.domain.Order;
import io.b2chat.bots.niviconsultas.domain.User;

public class RenderTemplateTG extends ARenderTemplate {

	@SuppressWarnings("unused")
	private MessageSending createMessageSending(String msg){
		MessageSending msgSending = null;
		msgSending = new MessageSending(msg);
		return msgSending;
	}

	@Override
	public List<MessageSendingBase> orderFollowUpOrderDetailNoGuide(Order order, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> orderFollowUpOrderDetailGuide(Order order, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> userRegistrationInstructions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForFullname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForFullnameWrongFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForEmailWrongFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForCellphone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForCellphoneWrongFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> userRegistrationSuccess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> bootstrapWelcoming() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> bootstrapLoggedUserMenu(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> bootstrapAskForUserIdentification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> bootstrapAskForUserIdentificationWrongFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> bootstrapAskForUserIdentificationFailed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> searchCampaignMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> searchCampaignDetail(Campaign campaign) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> searchCampaignFailed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> orderFollowUpMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> orderFollowUpOrderIdWrongFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageSendingBase> orderFollowUpOrderIdFailed() {
		// TODO Auto-generated method stub
		return null;
	}

}
