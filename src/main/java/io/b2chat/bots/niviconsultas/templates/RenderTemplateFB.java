package io.b2chat.bots.niviconsultas.templates;

import java.util.ArrayList;
import java.util.List;

import com.vertical.messagingservices.model.MessageSending;
import com.vertical.messagingservices.model.MessageSendingBase;

import io.b2chat.bots.niviconsultas.domain.Campaign;
import io.b2chat.bots.niviconsultas.domain.Order;
import io.b2chat.bots.niviconsultas.domain.User;
import io.b2chat.bots.util.widgets.Facebook;

public class RenderTemplateFB extends ARenderTemplate {

	@Override
	public List<MessageSendingBase> bootstrapWelcoming() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("bootstrap.welcoming", null, null)));
		messages.add(Facebook.generateButtonTemplate(
			this.messageSource.getMessage("bootstrap.whatdoyouwanttodo", null, null),
			String.format("/requestcatalog@%s;//userlogin@%s", 
				this.messageSource.getMessage("common.requestyourcatalog", null, null),
				this.messageSource.getMessage("common.toenter", null, null)
			)
		));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> bootstrapLoggedUserMenu(User user) {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(Facebook.generateButtonTemplate(
			this.messageSource.getMessage("bootstrap.selectfrommenu", new Object[] { user.getFullname() }, null), 
			String.format("/searchcampaign@%s;/identifypayment@%s;/orderfollowup@%s", 
				this.messageSource.getMessage("common.searchcampaign", null, null),
				this.messageSource.getMessage("common.identifypayment", null, null),
				this.messageSource.getMessage("common.orderfollowup", null, null)
			)
		));
		messages.add(Facebook.generateButtonTemplate(
			this.messageSource.getMessage("common.buttonssplit", null, null), 
			String.format("/faqs@%s;/chat@%s", 
				this.messageSource.getMessage("common.frequentquestions", null, null),
				this.messageSource.getMessage("common.chatwithagent", null, null)
			)
		));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> bootstrapAskForUserIdentification() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("bootstrap.askforuseridentification", null, null)));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> bootstrapAskForUserIdentificationWrongFormat() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("bootstrap.askforuseridentificationwrongformat", null, null)));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> bootstrapAskForUserIdentificationFailed() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(Facebook.generateButtonTemplate(
			this.messageSource.getMessage("bootstrap.askforuseridentificationfailed", null, null), 
			String.format("//askforidentification@%s;/requestyourcatalog@%s;/chat@%s", 
				this.messageSource.getMessage("common.tryagain", null, null),
				this.messageSource.getMessage("common.requestyourcatalog", null, null),
				this.messageSource.getMessage("common.chatwithagent", null, null)
			)
		));
		return messages;
	}

	@Override
	public List<MessageSendingBase> searchCampaignMenu() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(Facebook.generateButtonTemplate(
			this.messageSource.getMessage("searchcampaign.whatcampaigntosearch", null, null), 
			String.format("//current@%s;//next@%s", 
				this.messageSource.getMessage("common.current", null, null),
				this.messageSource.getMessage("common.next", null, null)
			)
		));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> searchCampaignDetail(Campaign campaign){
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(Facebook.generateButtonTemplate(
			this.messageSource.getMessage("searchcampaign.detail", new Object[] { campaign.getType() }, null), 
			String.format("/reset@%s", 
				this.messageSource.getMessage("common.mainmenu", null, null)
			)
		));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> searchCampaignFailed(){
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(Facebook.generateButtonTemplate(
			this.messageSource.getMessage("searchcampaign.selectcampaignfailed", null, null), 
			String.format("//startover@%s;/reset@%s;/chat@%s", 
				this.messageSource.getMessage("common.tryagain", null, null),
				this.messageSource.getMessage("common.mainmenu", null, null),
				this.messageSource.getMessage("common.chatwithagent", null, null)
			)
		));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> orderFollowUpMenu() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("orderfollowup.askforordernumber", null, null)));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> orderFollowUpOrderIdWrongFormat() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("orderfollowup.askforordernumberwrongformat", null, null)));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> orderFollowUpOrderIdFailed() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(Facebook.generateButtonTemplate(
			this.messageSource.getMessage("orderfollowup.askforordernumberfailed", null, null), 
			String.format("/reset@%s;/chat@%s", 
				this.messageSource.getMessage("common.mainmenu", null, null),
				this.messageSource.getMessage("common.chatwithagent", null, null)
			)
		));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> orderFollowUpOrderDetailNoGuide(Order order, User user) {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(Facebook.generateButtonTemplate(
			this.messageSource.getMessage("orderfollowup.detailnoguide", new Object[] { user.getIdentification() }, null), 
			String.format("//askfororderid@%s;/reset@%s;/chat@%s", 
				this.messageSource.getMessage("orderfollowup.askforanotherordernumber", null, null),
				this.messageSource.getMessage("common.mainmenu", null, null),
				this.messageSource.getMessage("common.chatwithagent", null, null)
			)
		));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> orderFollowUpOrderDetailGuide(Order order, User user) {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(Facebook.generateButtonTemplate(
			this.messageSource.getMessage("orderfollowup.detailguide", new Object[] { user.getIdentification() }, null), 
			String.format("//askfororderid@%s;/reset@%s;/chat@%s", 
				this.messageSource.getMessage("orderfollowup.askforanotherordernumber", null, null),
				this.messageSource.getMessage("common.mainmenu", null, null),
				this.messageSource.getMessage("common.chatwithagent", null, null)
			)
		));
		return messages;
	}
	
	@Override
	public List<MessageSendingBase> userRegistrationInstructions() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("userregistration.instructions", null, null)));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForFullname() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("userregistration.askforfullname", null, null)));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForFullnameWrongFormat() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("userregistration.askforfullnamewrongformat", null, null)));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForEmail() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("userregistration.askforemail", null, null)));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForEmailWrongFormat() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("userregistration.askforemailwrongformat", null, null)));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForCellphone() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("userregistration.askforcellphone", null, null)));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationAskForCellphoneWrongFormat() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("userregistration.askforcellphonewrongformat", null, null)));
		return messages;
	}

	@Override
	public List<MessageSendingBase> userRegistrationSuccess() {
		List<MessageSendingBase> messages = new ArrayList<MessageSendingBase>();
		messages.add(new MessageSending(this.messageSource.getMessage("userregistration.success", null, null)));
		messages.add(Facebook.generateButtonTemplate(
			this.messageSource.getMessage("common.whatdoyouwanttodo", null, null), 
			String.format("/reset@%s;/chat@%s", 
				this.messageSource.getMessage("common.mainmenu", null, null),
				this.messageSource.getMessage("common.chatwithagent", null, null)
			)
		));
		return messages;
	}
	
}
