package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	
	private Map<String, String> sessionUserMap = new HashMap<>();
	
	private Map<User,String> userMessages = new HashMap<>(); 
	
	public ChatImpl() throws RemoteException, MalformedURLException, NotBoundException {
		super();
		this.authService = (IAuthentication)Naming.lookup("rmi://localhost:1098/authenticationService");
		
	}
	public JFrame connexion(String sessionId) throws RemoteException, MalformedURLException, NotBoundException {
		
		boolean sessionCheck = authService.validateSession(sessionId);
		if(!sessionCheck) {
			return null;
		}
		System.out.println("session  "+sessionCheck);
		return new ChatView(sessionId).getChatView();
	}

	@Override
	public boolean deconnexion() throws RemoteException {
		
		return false;
	}

	public void send(String sessionId,String message,JPanel view) throws RemoteException {
		
	
		if(this.authService.getUserBySessionId(sessionId)!=null) {
			User sender = this.authService.getUserBySessionId(sessionId);
			userMessages.put(sender,message);
			
			
			return;
		}
			
		
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
