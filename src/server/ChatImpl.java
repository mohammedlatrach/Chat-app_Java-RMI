package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import authentication.server.IAuthentication;
import entities.User;
import view.chat.ChatView;
//This class implements the Chat interface, ou ChatImpl exlpicitement
public class ChatImpl extends UnicastRemoteObject implements Chat {

	
	
	//private ArrayList<User> registredUsers = new ArrayList<>();
	
	private IAuthentication authService;
	
	/*
	public static void main(String[] args) {
		System.out.print("CC");
	}
	*/
	
	public ChatImpl() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated constructor stub
		super();
		authService = (IAuthentication)Naming.lookup("rmi://localhost:1098/authenticationService");
	}
	// ici je doit envoyer l'appli de chat, alr la valeur de retour doit être le type ChatApp
	public JFrame connexion(String sessionId) throws RemoteException {
		
		boolean sessionCheck = authService.validateSession(sessionId);
		if(!sessionCheck) {
			return null;
		}
		return new ChatView().getChatView();
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
	public String registration(User user) throws RemoteException{
		/*
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
		return response;*/
		return "test";
	}
	
	public String test() throws RemoteException {
		return "Hello from Server side";
	}

}
