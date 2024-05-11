package authentication.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entities.User;

public class AuthenticationImpl extends UnicastRemoteObject implements IAuthentication{
	
	/* the process of the app, is as follows, you have to register each time it's launched, then you can login
	//or type some static login and  */
	
	private SessionManager sessionManager;
    
	/*10.05.24 21:20
	//private Map<String, String> userCredentials;*/
	private ArrayList<User> users = new ArrayList<>();
	
	public AuthenticationImpl() throws RemoteException {
		this.sessionManager = new SessionManager();
		/*10.05.24 21:20
		//this.userCredentials = new HashMap< >();
		//userCredentials.put("med", "123");
		//userCredentials.put("said", "123");
		//userCredentials.put("mm", "123");
		*/
		// adding some users because no registrations yet
		users.add(new User("liberation","123","mohamed","lt",null,false));
		users.add(new User("friend","123","said","th",null,false));
	}

	public String authentication(String login, String password) throws RemoteException {
		
		/*10.05.24 21:20
		if(userCredentials.containsKey(login) && userCredentials.get(login).equals(password)) {
			
			String sessionId = sessionManager.createSession(login);
			return sessionId;
		}
		*/
		///10.05.24 21:20
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
		//System.out.println("i entered then brake");
		for(User user : users) {
	        if(user != null && user.getSessionCode().equals(sessionId)) {
	            System.out.println("user "+user);
	            return user;
	        }
	    }
	    return null;
		
	}
	

	public String registration(String login, String password) throws RemoteException {
		
		/*
		if(!userCredentials.containsKey(login)) {
			String sessionId = sessionManager.createSession(login);
			return sessionId;
		}
		*/
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
