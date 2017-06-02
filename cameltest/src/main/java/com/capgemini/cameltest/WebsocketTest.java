package com.capgemini.cameltest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@ServerEndpoint("/websocketTest/{username}")
public class WebsocketTest {
	
	private static Log log = LogFactory.getLog(WebsocketTest.class);
	
	public static Map<String,Session>  map = new HashMap<String,Session>();
	
	
	private Session session;
	
	@OnMessage
	public void onMessage(@PathParam("username") String username,String message) throws IOException, InterruptedException {

		log.info("Received: " + message);

		log.info(username+ "  session id is "+session.getId()+" " +session.toString());
		// Print the client message for testing purposes
	
		// Send the first message to the client
		session.getBasicRemote().sendText(message+" This is the first server message");
		

		// Send 3 messages to the client every 5 seconds
		int sentMessages = 0;
		while (sentMessages < 3) {
			Thread.sleep(5000);
			session.getBasicRemote().sendText(message+" This is an intermediate server message. Count: " + sentMessages);
			sentMessages++;
		}

		// Send a final message to the client
		session.getBasicRemote().sendText(message+" This is the last server message");
	}

	@OnOpen
	public void onOpen(@PathParam("username") String username,Session session) {
		
		log.info(username+"  session id is "+session.getId()+ " "+session.toString());;
		
		this.session = session;
		log.info("onOpen: Client connected");
		
	}

	@OnClose
	public void onClose() {
		log.info("closeing session id:"+session.getId());
		log.info("Connection closed");
	}
}