package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server {

	public Server() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws RemoteException {
		
		ChatImpl myRemoteChatObject = new ChatImpl();
		
		// register ou annuaire
		Registry register = LocateRegistry.createRegistry(1099);
		register.rebind("remoteChatObject",myRemoteChatObject);
		
		System.out.println("Server is running");
	}

}
