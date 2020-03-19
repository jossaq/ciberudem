package io.b2chat.bots.niviconsultas.domain;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Campaign {
	
	private Integer id;
	private String type;
	private ZonedDateTime initialDate;
	private ZonedDateTime finalDate;
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ZonedDateTime getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(ZonedDateTime initialDate) {
		this.initialDate = initialDate;
	}

	public ZonedDateTime getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(ZonedDateTime finalDate) {
		this.finalDate = finalDate;
	}
	
}