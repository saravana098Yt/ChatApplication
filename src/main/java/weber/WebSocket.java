package weber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/websocket")
public class WebSocket {
    public static List<Session> users=new ArrayList<Session>();
    
@OnOpen
public void open(Session ses) {
	int size = users.stream().filter(n->n.getId() == ses.getId()).toList().size();
	if(size==0)
		users.add(ses);
}

@OnClose
public void close(Session ses) {
	users.remove(ses);
}

@OnMessage
public void message(String message,Session ses) {
	users.forEach(n->{
		try {
			n.getBasicRemote().sendText(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	});
	}
	
}
