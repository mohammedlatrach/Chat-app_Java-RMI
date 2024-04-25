package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat extends Remote {
	public String connexion(String user_name,String password) throws RemoteException;
	
	public boolean deconnexion() throws RemoteException;
	
	// ce message doit être de type Message pour après
	public void envoyer(String message) throws RemoteException;
	
	public void recevoir(String message) throws RemoteException;;
}
