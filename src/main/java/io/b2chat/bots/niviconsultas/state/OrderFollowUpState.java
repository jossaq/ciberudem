package io.b2chat.bots.niviconsultas.state;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.vertical.bot.domain.MessagingAccount;
import com.vertical.messagingservices.model.MessageSendingBase;

import io.b2chat.bots.niviconsultas.Context;
import io.b2chat.bots.niviconsultas.domain.Order;
import io.b2chat.bots.niviconsultas.services.OrderService;

public class OrderFollowUpState extends AState {

	private static final long serialVersionUID = 1349778918166930837L;

	public transient static final int ORDER_ID = 0;
	public transient static final int ORDER_DETAIL = 1;
	
	private Order order;
	
	public OrderFollowUpState() {
		this.setStep(ORDER_ID);
	}
	
	@Override
	public List<MessageSendingBase> receiveMessage(Context context, MessagingAccount messaging, String message) {
		switch (this.getStep()) {
			case ORDER_ID: return this.orderId(context, message);
			case ORDER_DETAIL: return this.orderDetail(context, this.getOrder());
			default: return null;
		}
	}
	
	public List<MessageSendingBase> orderId(Context context, String message) {
				
		if (message != null) {

			if (message.equalsIgnoreCase("//askfororderid"))
				return context.getRenderTemplate().orderFollowUpMenu();
			
			if (StringUtils.length(message) > 10 || !StringUtils.isNumeric(message))
				return context.getRenderTemplate().orderFollowUpOrderIdWrongFormat();
			
			Order order = new Order();
			order.setIdentification(message);
			order = new OrderService().getByIdentification(order);
			if (order.getId() == null)
				return context.getRenderTemplate().orderFollowUpOrderIdFailed();
			
			return this.orderDetail(context, order);
		}
		return context.getRenderTemplate().orderFollowUpMenu();
	}
	 
	public List<MessageSendingBase> orderDetail(Context context, Order order) {
		
		this.setOrder(order);
		
		if (this.getOrder().getInvoiceNumber() == null)
			return context.getRenderTemplate().orderFollowUpOrderDetailNoGuide(this.getOrder(), context.getUser());
		
		return context.getRenderTemplate().orderFollowUpOrderDetailGuide(this.getOrder(), context.getUser());
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
