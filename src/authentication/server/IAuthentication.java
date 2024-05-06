package authentication.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAuthentication extends Remote{

	public String authentication (String login,String password) throws RemoteException;
	public String registration   (String login, String password) throws RemoteException;
	
	//these two methods are for the chat server
	public boolean validateSession (String sessionId);
	public void invalidateSession (String sesisonId);
}
