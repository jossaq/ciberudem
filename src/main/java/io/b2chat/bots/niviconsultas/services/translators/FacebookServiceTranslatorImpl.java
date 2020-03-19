package io.b2chat.bots.niviconsultas.services.translators;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.b2chat.bots.niviconsultas.domain.AccountUserProfile;

@Component
public class FacebookServiceTranslatorImpl implements FacebookServiceTranslator{
	
	static final Logger logger = LoggerFactory.getLogger(FacebookServiceTranslatorImpl.class);

	@Override
	public AccountUserProfile translate(String data) {
		String json = (String) data;
		AccountUserProfile userProfile = null;
		if(json != null){
			try{
				JSONObject jsonObj = new JSONObject(json);
				String firstName = jsonObj.optString("first_name");
				String lastName = jsonObj.optString("last_name");
				
				userProfile = new AccountUserProfile(firstName, lastName);
				
				logger.debug("<OK TO TRANSLATE TO USER PROFILE>");
				
			}catch(Exception e){
				logger.error("<ERROR TO TRANSLATE TO USER PROFILE> Cause: {}", e);
			}
			
		}
		return userProfile;
	}

}
