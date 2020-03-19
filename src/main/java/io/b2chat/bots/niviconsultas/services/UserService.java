package io.b2chat.bots.niviconsultas.services;

import org.springframework.stereotype.Component;

import io.b2chat.bots.niviconsultas.domain.User;

@Component
public class UserService {
	
	public User authenticate(User user) {
		String validAuthentication = "123456";
		if (user.getIdentification().equals(validAuthentication)) {
			user.setId(1);
			user.setFullname("John Appleseed");
		}
		return user; 
	}
	
	public User saveForRegistration(User user) {
		return null;
	}
	
}