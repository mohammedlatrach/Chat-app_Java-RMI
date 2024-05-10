package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import authentication.server.IAuthentication;
import entities.User;
import view.chat.ChatView;

public class ChatImpl extends UnicastRemoteObject implements Chat {

	
	
	
	private IAuthentication authService;
	
	//10.05.24 11:34
	private List<String> messages = new ArrayList<String>(); 
	
	public ChatImpl() throws RemoteException, MalformedURLException, NotBoundException {
		super();
		authService = (IAuthentication)Naming.lookup("rmi://localhost:1098/authenticationService");
		
		//10.05.24 11:34
		
	}
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
		
		return "test";
	}
	
	public String test() throws RemoteException {
		return "Hello from Server side";
	}

}
