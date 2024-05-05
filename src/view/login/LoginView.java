package view.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
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

import view.window.Window;

public class LoginView {

	public LoginView() {

	}

	public static void main(String[] args) {
		
		JFrame loginViewtest = getLoginView();
		
	}	
	
	public static JFrame getLoginView() {
		
		JFrame loginWindow = Window.getWindow();
		Container view = loginWindow.getContentPane();
		view.setBackground(new Color(240, 240, 240));
		
		
		//;
		JPanel inputContainer = new JPanel();
		inputContainer.setLayout(new BoxLayout(inputContainer, BoxLayout.Y_AXIS));
		//inputContainer.add(Box.createRigidArea(new Dimension(0,25)));
		view.add(inputContainer);
		
		
		
		JTextField loginField = Input.getInput("textInput");
		
		//loginField.addActionListener(loginField);
		
		JTextField passwordField = Input.getInput("passwordInput");
		
		inputContainer.add(Label.getLabel("Login"));
		inputContainer.add(loginField);
		inputContainer.add(Box.createRigidArea(new Dimension(0,40)));
		inputContainer.add(Label.getLabel("Password"));
		inputContainer.add(passwordField);
		//inputContainer.setBounds(0,0,400,600);
		
		
		
		JPanel buttonContainer = new JPanel();
		buttonContainer.setLayout(new FlowLayout());
		//buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.Y_AXIS));
		buttonContainer.add(Box.createRigidArea(new Dimension(0,25)));
		
		
		
		JButton connexionButton = Button.getButton("CONNEXION");
		JButton registerButton = Button.getButton("REGISTER");
		
		buttonContainer.add(connexionButton);
		inputContainer.add(Box.createRigidArea(new Dimension(0,40)));
		buttonContainer.add(registerButton);
		view.add(buttonContainer);
		
		
		view.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));
		
		
		loginWindow.setVisible(true);
		return loginWindow;
		
	}

}
