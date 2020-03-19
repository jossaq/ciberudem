package io.b2chat.bots.niviconsultas.state;

import java.util.ArrayList;
import java.util.List;
import com.vertical.bot.domain.MessagingAccount;
import com.vertical.messagingservices.model.MessageSendingBase;
import io.b2chat.bots.niviconsultas.Context;

public class ForwardToChatState extends AState{

	private static final long serialVersionUID = 5287021961520641261L;
	
	@Override
	public List<MessageSendingBase> receiveMessage(Context context, MessagingAccount account, String message) {
		return new ArrayList<MessageSendingBase>();
	}
}
