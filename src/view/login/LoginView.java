package view.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import authentication.server.IAuthentication;
import view.window.Window;

public class LoginView {

	public LoginView() {

	}	
	
	public static JFrame getLoginView() throws MalformedURLException, RemoteException, NotBoundException {
		
		JFrame loginWindow = Window.getWindow();
		Container view = loginWindow.getContentPane();
		view.setBackground(new Color(240, 240, 240));
		
		
		Input loginField = new Input();	
		Input passwordField = new Input();
		
		
		
		JButton connexionButton = Button.getButton("CONNEXION");
		JButton registerButton = Button.getButton("REGISTER");
			
		
		
		LoginViewLayout loginViewLayout = new LoginViewLayout(loginField,Label.getLabel("Login"), passwordField,
												Label.getLabel("Password"), connexionButton, registerButton);
		loginViewLayout.getLoginViewLayout(view);
		
		
		
		//establishing connection to auth server
		IAuthentication authService = (IAuthentication)Naming.lookup("rmi://localhost:1099/authenticationService");
		
		/*event dispatching*/
		connexionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(loginField.getInputValue());
				//System.out.println(passwordField.getInputValue());
				try {
					
					String response  = authService.authentication(loginField.getInputValue(), passwordField.getInputValue());
					
					
					
					//System.out.println("response from auth serve : "+response);
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}
			}
        });

		
		
		loginWindow.setVisible(true);
		return loginWindow;
		
	}

}
