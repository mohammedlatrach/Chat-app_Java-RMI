package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entities.User;

public interface Chat extends Remote {
	
	
	public String test() throws RemoteException;
	
	public String connexion(String user_name,String password) throws RemoteException;
	
	public boolean deconnexion() throws RemoteException;
	
	public String registration(User user) throws RemoteException;
	
	// ce message doit être de type Message pour après
	public void send(String message) throws RemoteException;
	
	public void receive(String message) throws RemoteException;;
}
