package authentication.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationImpl extends UnicastRemoteObject implements IAuthentication{
	
	/* the process of the app, is as follows, you have to register each time it's launched, then you can login
	//or type some static login and  */
	
	private SessionManager sessionManager;
    private Map<String, String> userCredentials;
    
	public AuthenticationImpl() throws RemoteException {
		this.sessionManager = new SessionManager();
		this.userCredentials = new HashMap< >();
	}

	public String authentication(String login, String password) throws RemoteException {
		
		if(userCredentials.containsKey(login) && userCredentials.get(login).equals(password)) {
			
			String sessionId = sessionManager.createSession(login);
			return sessionId;
		}
		
		return "AUTHENTICATION_FAILED";
	}

	public String registration(String login, String password) throws RemoteException {

		if(!userCredentials.containsKey(login)) {
			String sessionId = sessionManager.createSession(login);
			return sessionId;
		}
		
		return "LOGIN_NOT_AVAILABLE";
	}

}
