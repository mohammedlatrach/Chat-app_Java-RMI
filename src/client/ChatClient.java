package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.Chat;

public class ChatClient {

	public ChatClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		
		Chat chatService =(Chat)Naming.lookup("rmi://localhost:1099/remoteChatObject");
		System.out.println(chatService.test());
	}

}
