package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
//This class implements the Chat interface, ou ChatImpl exlpicitement
public class ChatImpl extends UnicastRemoteObject implements Chat {

	/*
	public static void main(String[] args) {
		System.out.print("CC");
	}
	*/
	
	public ChatImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	public String test() throws RemoteException {
		return "Hello from Server side";
	}
	
	public boolean inscription(String user_name, String password) throws RemoteException{
		
		return false;
	}

	@Override
	public String connexion(String user_name, String password) throws RemoteException {
		
		return null;
	}

	@Override
	public boolean deconnexion() throws RemoteException {
		
		return false;
	}

	@Override
	public void envoyer(String message) throws RemoteException {
		
	}

	@Override
	public void recevoir(String message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
