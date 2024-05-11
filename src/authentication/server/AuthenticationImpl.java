package authentication.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entities.User;

public class AuthenticationImpl extends UnicastRemoteObject implements IAuthentication{

	
	private SessionManager sessionManager;
  
	private ArrayList<User> users = new ArrayList<>();
	
	public AuthenticationImpl() throws RemoteException {
		this.sessionManager = new SessionManager();
		users.add(new User("liberation","123","mohamed","lt",null,false));
		users.add(new User("friend","123","said","th",null,false));
	}

	public String authentication(String login, String password) throws RemoteException {
		for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                String sessionId = sessionManager.createSession(login);
                user.setSessionCode(sessionId);
                return sessionId;
            }
        }
		return "AUTHENTICATION_FAILED";
	}
	
	
	public User getUserBySessionId(String sessionId) {
		for(User user : users) {
	        if(user != null && user.getSessionCode().equals(sessionId)) {
	            System.out.println("user "+user);
	            return user;
	        }
	    }
	    return null;
		
	}
	

	public String registration(String login, String password) throws RemoteException {
		
		return "LOGIN_NOT_AVAILABLE";
	}


	
	
	public boolean validateSession(String sessionId) {
		String sessionVerification = sessionManager.isSessionValid(sessionId);
		if(sessionVerification=="SESSION_VALID") {
			return true;
		}
		
		return false;
	}


	public void invalidateSession(String sesisonId) {
		sessionManager.invalidateSession(sesisonId);
	}

}
