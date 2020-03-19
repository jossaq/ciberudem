package io.b2chat.bots.niviconsultas.domain;

import java.io.Serializable;

public class AccountUserProfile implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1964378368544387516L;
	
	/**
	 * This object contains Facebook profile information
	 */
	private String firstName;
	private String lastName;
	private String profilePic;
	private String locale;
	private String timezone;
	private String gender;
	private String isPaymentEnabled;
	private String lastAdReferral;
	
	
	
	public AccountUserProfile(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIsPaymentEnabled() {
		return isPaymentEnabled;
	}
	public void setIsPaymentEnabled(String isPaymentEnabled) {
		this.isPaymentEnabled = isPaymentEnabled;
	}
	public String getLastAdReferral() {
		return lastAdReferral;
	}
	public void setLastAdReferral(String lastAdReferral) {
		this.lastAdReferral = lastAdReferral;
	}
	
	

}
