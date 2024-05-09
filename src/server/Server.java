package server;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import entities.User;


public class Server {
	
	
	
	public Server() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		
		ChatImpl myRemoteChatObject = new ChatImpl();
		
		Registry register = LocateRegistry.createRegistry(1099);
		register.rebind("remoteChatObject",myRemoteChatObject);
		
		System.out.println("Server is running");
	}

}
