package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import server.Chat;

public class ChatClient {

	public ChatClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		
		Chat chatService =(Chat)Naming.lookup("rmi://localhost:1099/remoteChatObject");
		
		
		
		Scanner chatPrompt = new Scanner(System.in);
		boolean myApp = true;
		
		while(myApp) {
			System.out.println("Bienvenue dans le menu de l'application");

			System.out.println("Pour se connecter envoyer 1");
			System.out.println("Pour sortir cliquer envoyer 0");
			int userAnswer = chatPrompt.nextInt();
			
			if(userAnswer==0) {
				myApp=false;
				break;
			}
			
			if(userAnswer==1) {
				System.out.println("Bienvenue dans l'application de Chat");
				break;
			}
		}
		
		
		//System.out.println(chatService.test());
	}

}
