package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import entities.User;
import server.Chat;
import view.login.LoginView;

public class ChatClient {

	public ChatClient() {
		// TODO Auto-generated constructor stub
	}
	
	static private int  prompthingTheUser() {
		/*
		System.out.println("Bienvenue dans le Menu de l'application :");
		System.out.println("----------- Pour se connecter envoyez 1");
		System.out.println("----------- Pour s'inscrire cliquez envoyer 2");
		Scanner chatPrompt = new Scanner(System.in);
		return  chatPrompt.nextInt();
		*/
		return 1;
	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		
		
		(new LoginView()).getLoginView();
		/*
		Chat chatService =(Chat)Naming.lookup("rmi://localhost:1099/remoteChatObject");
		
		
		
		
		
		
		boolean myApp = true;
		
		while(myApp) {
			
			int userAnswer = prompthingTheUser();
			
			if(userAnswer==1) {
				System.out.println("Bienvenue dans l'application de Chat");
				userAnswer = prompthingTheUser();
				
			}else
				if(userAnswer==2) {
				System.out.println("Registration...");
				
				
				System.out.println("Saisir le login:");
				Scanner chatPrompt = new Scanner(System.in);
				String userLogin = chatPrompt.next();
				
				User newUser = new User(userLogin);
				String response = chatService.registration(newUser);
				System.out.println(response);
				
			}else {
				userAnswer = prompthingTheUser();
			}
			
		}
		*/
		
		//System.out.println(chatService.test());
	}

}
