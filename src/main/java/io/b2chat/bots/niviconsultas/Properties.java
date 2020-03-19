package io.b2chat.bots.niviconsultas;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
	
	//##### Facebook properties 
	@NotNull
	@Value("${facebook.userProfileUrl}")
	private String userProfileUrl;
	
	@NotNull
	@Value("${bot.FBtoken}")
	private String botFBToken;
	
	
	//##### Public methods
	public String getUserProfileUrl() {
		return userProfileUrl;
	}

	public String getBotFBToken() {
		return botFBToken;
	}
}
