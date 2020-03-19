package io.b2chat.bots.niviconsultas.state;

import java.util.List;

import com.vertical.bot.domain.MessagingAccount;
import com.vertical.messagingservices.model.MessageSendingBase;

import io.b2chat.bots.niviconsultas.Context;
import io.b2chat.bots.niviconsultas.domain.Campaign;
import io.b2chat.bots.niviconsultas.services.CampaignService;

public class SearchCampaignState extends AState {

	private static final long serialVersionUID = 1349778918166930837L;

	public transient static final int CAMPAIGN_SELECT = 0;
	public transient static final int CAMPAIGN_DETAIL = 1;
	
	private Campaign campaign;
	
	public SearchCampaignState() {
		this.setStep(CAMPAIGN_SELECT);
	}
	
	public List<MessageSendingBase> receiveMessage(Context context, MessagingAccount messaging, String message) {
		switch (this.getStep()) {
			case CAMPAIGN_SELECT: return this.campaignSelect(context, message);
			case CAMPAIGN_DETAIL: return this.campaignDetail(context, this.getCampaign());
			default: return null;
		}
	}
	
	public List<MessageSendingBase> campaignSelect(Context context, String message) {
		
		if (message != null) {
			
			if (message.equalsIgnoreCase("//startover"))
				return context.getRenderTemplate().searchCampaignMenu();
			
			if (message.equalsIgnoreCase("//current")) {
				Campaign campaign = new CampaignService().getCurrentCampaign();
				if (campaign.getId() == null)
					return context.getRenderTemplate().searchCampaignFailed();
				return context.getRenderTemplate().searchCampaignDetail(campaign);
			}
			if (message.equalsIgnoreCase("//next")) {
				Campaign campaign = new CampaignService().getNextCampaign();
				if (campaign.getId() == null)
					return context.getRenderTemplate().searchCampaignFailed();
				return context.getRenderTemplate().searchCampaignDetail(campaign);
			}
		}
		return context.getRenderTemplate().searchCampaignMenu();
	}
	 
	public List<MessageSendingBase> campaignDetail(Context context, Campaign campaign) {
		this.setCampaign(campaign);
		return context.getRenderTemplate().searchCampaignDetail(this.getCampaign());
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}
	
}
