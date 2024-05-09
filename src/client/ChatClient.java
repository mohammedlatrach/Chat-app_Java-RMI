package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.swing.JFrame;

import entities.User;
import server.Chat;
import view.login.LoginView;

public class ChatClient {

	public ChatClient() {
	}
	
	static private int  prompthingTheUser() {
	
		return 1;
	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		
		try {
			JFrame loginWindow = (new LoginView()).getLoginView();	
		}catch(Exception e) {
			System.out.print("The exception occurs in ChatClient.java, Exception :"+e);
		}
	
	}

}
