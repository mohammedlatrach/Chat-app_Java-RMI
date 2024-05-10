package view.login;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JFrame;
import authentication.server.IAuthentication;
import server.Chat;
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
		IAuthentication authService = (IAuthentication)Naming.lookup("rmi://localhost:1098/authenticationService");
		
		
		Chat chatService = (Chat)Naming.lookup("rmi://localhost:1099/remoteChatObject");
		
		
		/*event dispatching*/
		connexionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String response  = authService.authentication(loginField.getInputValue(), passwordField.getInputValue());
					
					//System.out.println(" Auth server response :"+response);
					
					try {
						chatService.connexion(response);
						loginWindow.dispose();
					}catch(Exception ee) {
						System.out.println("Exception "+ee);
					}
					
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}
			}
        });

		
		
		loginWindow.setVisible(true);
		return loginWindow;
		
	}

}
