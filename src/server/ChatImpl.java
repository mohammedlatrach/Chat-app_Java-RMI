package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import authentication.server.IAuthentication;
import entities.User;
import view.chat.ChatView;
import view.chat.TextMessagesStyle;

public class ChatImpl extends UnicastRemoteObject implements Chat {

	
	
	
	private IAuthentication authService;
	
	//10.05.24 21:07
	private Map<String, String> sessionUserMap = new HashMap<>();
	private Map<String, ChatView> connectedClients =new HashMap<>();
	//10.05.24 11:34 the user
	private Map<User,String> userMessages = new LinkedHashMap<>(); 
	
	public ChatImpl() throws RemoteException, MalformedURLException, NotBoundException {
		super();
		this.authService = (IAuthentication)Naming.lookup("rmi://localhost:1098/authenticationService");
		
		//10.05.24 11:34
		
	}
	public void connexion(String sessionId) throws RemoteException, MalformedURLException, NotBoundException {
		
		boolean sessionCheck = authService.validateSession(sessionId);
		if(!sessionCheck) {
			return;
		}
		System.out.println("session  "+sessionCheck);
		ChatView chatView = new ChatView(sessionId);
	    
	    // Add the chatView to connectedClients map
	    connectedClients.put(sessionId, chatView);
		//new ChatView(sessionId);
	}

	@Override
	public boolean deconnexion() throws RemoteException {
		
		return false;
	}

	public void send(String sessionId,String message) throws RemoteException {
		
			//User user =this.authService.getUserBySessionId(sessionId);
		if(this.authService.getUserBySessionId(sessionId)!=null) {
			User sender = this.authService.getUserBySessionId(sessionId);
			userMessages.put(sender,message);
			//System.out.println("Message envoyé avec succée");
			/*
			view.add(new TextMessagesStyle(message));
			view.revalidate();
			view.repaint();
			*/
			/*
			for (Map.Entry<User, String> entry : userMessages.entrySet()) {
			    User user = entry.getKey();
			    String msg = entry.getValue();
			    System.out.println(user.getFirstName() + " " + user.getLastName() + " : " + msg);
			}
			*/
			for (ChatView client : connectedClients.values()) {
	            client.receiveMessage(sender,message);
	        }
			return;
		}
			//System.out.println(" : ");
			//System.out.println("Message non envoyé, ChatImpl.send()");
		
	}	

	@Override
	public void receive(String message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	public String registration(User user) throws RemoteException{
		
		return "test";
	}
	
	public String test() throws RemoteException {
		return "Hello from Server side";
	}
	
	public Map<User, String> getUserMessages() throws RemoteException{
        return userMessages;
    }
	
	
	

}
