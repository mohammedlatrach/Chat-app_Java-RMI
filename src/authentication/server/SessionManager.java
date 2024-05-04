package authentication.server;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionManager {

	//the map has the sessionID and session
	private Map<String, Session> sessions;
	
	
	public SessionManager() {
		 sessions = new HashMap<>();
	}
	
	
	public String createSession(String login) {
		String sessionId = UUID.randomUUID().toString()+System.currentTimeMillis();
		Session session = new Session(login,System.currentTimeMillis());
		sessions.put(sessionId,session);
		return sessionId;
	}
	
	
	public String isSessionValid(String sessionId) {
		
		if(!sessions.containsKey(sessionId)) {
			return "SESSION_INVALID";
		}

		return "SESSION_VALID";
	}
	
	
	public void invalidateSession(String sessionId) {
		sessions.remove(sessionId);
	}
	

}
