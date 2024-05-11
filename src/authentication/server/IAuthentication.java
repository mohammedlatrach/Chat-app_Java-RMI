package authentication.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entities.User;

public interface IAuthentication extends Remote{

	public String authentication (String login,String password) throws RemoteException;
	public String registration   (String login, String password) throws RemoteException;
	
	//these two methods are for the chat server
	public boolean validateSession (String sessionId) throws RemoteException;
	public void invalidateSession (String sesisonId) throws RemoteException;
	
	public User getUserBySessionId(String sessionId) throws RemoteException;
}
