package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

import entities.User;
//This class implements the Chat interface, ou ChatImpl exlpicitement
public class ChatImpl extends UnicastRemoteObject implements Chat {

	
	
	private ArrayList<User> registredUsers = new ArrayList<>();
	
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
	
	
	public String registration(User user) throws RemoteException{
		
		String response="response";
		
		if(registredUsers.isEmpty()) {
			this.registredUsers.add(user);
			response = "Successful registration";
			return response;
		}
		
		Iterator<User> it = this.registredUsers.iterator();
		while(it.hasNext()) {
			User userIterator = it.next();
			
			// check if the user already exists
			if(userIterator.getLogin() == user.getLogin()) {
				System.out.println("Login not available");
				response = "Login not available";
				return response;
			}else {
				System.out.println("Successful registration");
				this.registredUsers.add(user);
				response =  "Successful registration";
				return response;
			}
		}
		return response;
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
	public void send(String message) throws RemoteException {
		
	}

	@Override
	public void receive(String message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
