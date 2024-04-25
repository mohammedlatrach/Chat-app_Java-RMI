package server;

import java.rmi.RemoteException;
//This class implements the Chat interface
public class RemoteChatObject implements Chat{

	/*
	public static void main(String[] args) {
		System.out.print("CC");
	}
	*/
	
	public RemoteChatObject() {
		// TODO Auto-generated constructor stub
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
