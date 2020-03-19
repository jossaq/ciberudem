package io.b2chat.bots.niviconsultas.state;

import java.io.Serializable;
import java.util.List;


import com.vertical.bot.domain.MessagingAccount;
import com.vertical.messagingservices.model.MessageSendingBase;

import io.b2chat.bots.niviconsultas.Context;

public interface IState extends Serializable {
	
	public List<MessageSendingBase> receiveMessage(Context context, MessagingAccount account, String message);
	
}
