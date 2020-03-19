package io.b2chat.bots.niviconsultas.templates;

import java.util.ArrayList;
import java.util.List;

import com.vertical.messagingservices.model.MessageSending;
import com.vertical.messagingservices.model.MessageSendingBase;

import io.b2chat.bots.niviconsultas.domain.Campaign;
import io.b2chat.bots.niviconsultas.domain.Order;
import io.b2chat.bots.niviconsultas.domain.User;

public class RenderTemplateWA extends ARenderTemplate {

	@Override
	public List<MessageSendingBase> bootstrapWelcoming() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("bootstrap.welcoming", null, null)));
		messages.add(new MessageSending(this.messageSource.getMessage("common.requestyourcatalog", null, null)));
		messages.add(new MessageSending(this.messageSource.getMessage("common.toenter", null, null)));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> bootstrapLoggedUserMenu(User user) {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("bootstrapLoggedUserMenu"));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> bootstrapAskForUserIdentification() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("bootstrapAskForUserIdentification"));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> bootstrapAskForUserIdentificationWrongFormat() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("bootstrapAskForUserIdentificationWrongFormat"));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> bootstrapAskForUserIdentificationFailed() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("bootstrapAskForUserIdentificationFailed"));
		return messages;
	}

	@Override
	public List<MessageSendingBase> searchCampaignMenu() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("searchCampaignMenu"));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> searchCampaignDetail(Campaign campaign){
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("searchCampaignDetail"));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> searchCampaignFailed(){
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("searchCampaignFailed"));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> orderFollowUpMenu() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("orderFollowUpMenu"));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> orderFollowUpOrderIdWrongFormat() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("orderFollowUpOrderIdWrongFormat"));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> orderFollowUpOrderIdFailed() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("orderFollowUpOrderIdFailed"));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> orderFollowUpOrderDetailNoGuide(Order order, User user) {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("orderFollowUpOrderDetailNoGuide"));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> orderFollowUpOrderDetailGuide(Order order, User user) {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("orderFollowUpOrderDetailGuide"));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> userRegistrationInstructions() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("userRegistrationInstructions"));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForFullname() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("userRegistrationAskForFullname"));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForFullnameWrongFormat() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("userRegistrationAskForFullnameWrongFormat"));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForEmail() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("userRegistrationAskForEmail"));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForEmailWrongFormat() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("userRegistrationAskForEmailWrongFormat"));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForCellphone() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("userRegistrationAskForCellphone"));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForCellphoneWrongFormat() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("userRegistrationAskForCellphoneWrongFormat"));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationSuccess() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending("userRegistrationSuccess"));
		return messages;
	}
	
}
