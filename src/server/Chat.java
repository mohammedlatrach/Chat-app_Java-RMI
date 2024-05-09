package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.JFrame;

import entities.User;

public interface Chat extends Remote {
	
	
	public String test() throws RemoteException;
	
	
	//connexion must be with session, upon validation with the auth server then send chat view
	public JFrame connexion(String sessionId) throws RemoteException;
	
	public boolean deconnexion() throws RemoteException;
	
	public String registration(User user) throws RemoteException;
	
	// Must of type Message to handle Image and other content types
	public void send(String message) throws RemoteException;
	
	public void receive(String message) throws RemoteException;;
}
