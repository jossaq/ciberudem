package io.b2chat.bots.niviconsultas.services;

import org.springframework.stereotype.Component;

import io.b2chat.bots.niviconsultas.domain.Order;

@Component
public class OrderService {

	public Order getByIdentification(Order order) {
		String validOrderIdentificationNoGuide= "1234";
		if (order.getIdentification().equals(validOrderIdentificationNoGuide)) {
			order.setId(1);
		}
		String validOrderIdentificationGuide= "12345";
		if (order.getIdentification().equals(validOrderIdentificationGuide)) {
			order.setId(1);
			order.setInvoiceNumber("12345");
		}		
		return order;
	}
	
}
