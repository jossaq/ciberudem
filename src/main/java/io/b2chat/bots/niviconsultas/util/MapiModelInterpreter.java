package io.b2chat.bots.niviconsultas.util;

import com.vertical.messagingservices.model.IncomingMessage;
import com.vertical.messagingservices.model.IncomingTextMessage;

/**
 * Provides utilitarian functionalites to work with the MAPI model
 * @author slondono
 */
public class MapiModelInterpreter {
  
  /**
   * Converts the provided incoming message to a text message if possible, otherwise returns null
   * @param msg Incoming message to be interpreted as text
   * @return Text message or null if the provided message is either null or a non-text message
   */
  public static IncomingTextMessage asTextMessage(IncomingMessage msg) {
    IncomingTextMessage txtMsg = null;
    
    // Check that incoming message is a text message
    if (msg != null && (msg instanceof IncomingTextMessage)) {
      // Get incoming text message
      txtMsg = (IncomingTextMessage)msg;
    }
    
    return txtMsg;
  }

  public static IncomingTextMessage asTextMessage(Exception error) {
	  IncomingTextMessage txtMsg = new IncomingTextMessage();
	  txtMsg.setMessage(error.getMessage().replace(" ", "_"));
	  return txtMsg;
  }

  public static IncomingTextMessage asCloseChat() {
	  IncomingTextMessage txtMsg = new IncomingTextMessage();
	  txtMsg.setMessage("close_chat");
	  return txtMsg;
  }

}
