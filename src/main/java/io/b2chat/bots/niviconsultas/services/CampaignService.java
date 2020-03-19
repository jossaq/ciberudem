package io.b2chat.bots.niviconsultas.services;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

import io.b2chat.bots.niviconsultas.domain.Campaign;

@Component
public class CampaignService {

	public Campaign getCurrentCampaign() {
		return new Campaign(); 
	}
	
	public Campaign getNextCampaign() {
		Campaign campaign = new Campaign();
		campaign.setId(1);
		campaign.setType("Actual");
		campaign.setInitialDate(ZonedDateTime.now());
		campaign.setFinalDate(ZonedDateTime.now().plusMonths(12));
		return campaign;
	}
	
}
