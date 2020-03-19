package io.b2chat.bots.niviconsultas.infraestructure.http;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FacebookManager implements Serializable{
	

	private static final long serialVersionUID = 4399230448278587330L;
	static final Logger logger = LoggerFactory.getLogger(FacebookManager.class);
	
	/**
	 * Consume servicios de facebook
	 * */
	public String getUserProfile(String uri) {
		try {	

			RestTemplate restTemplate = new RestTemplate();
			
			String body = (String) restTemplate.getForObject(uri, String.class);
			
			logger.debug("<RESPONSE TO GET USER PROFILE: {}> ", body);
			return body;
		}catch (Exception e) {
			logger.error("<ERROR GETTING USER PROFILE FROM FACEBOOK {}>",e);
			
		}
		
		return null;
	}

}


