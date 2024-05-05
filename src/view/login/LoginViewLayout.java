package view.login;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginViewLayout {

	JTextField loginField;
	JTextField passwordField;
	JButton connexionButton;
	JButton registerButton;
	JLabel loginLabel;
	JLabel passwordLabel;
	public LoginViewLayout(JTextField loginField,JLabel loginLabel, JTextField passwordField,JLabel passwordLabel,
			JButton connexioButton,JButton registerButton) {
		
		this.loginField=loginField;
		this.loginLabel=loginLabel;
		
		this.passwordField=passwordField;
		this.passwordLabel=passwordLabel;
		
		this.connexionButton=connexioButton;
		this.registerButton=registerButton;
		
	}
	
	public Container getLoginViewLayout(Container view) {
		
		
		
		
		JPanel inputContainer = new JPanel();
		inputContainer.setLayout(new BoxLayout(inputContainer, BoxLayout.Y_AXIS));
		
		inputContainer.add(this.loginLabel);
		inputContainer.add(this.loginField);
		
		inputContainer.add(Box.createRigidArea(new Dimension(0,40)));
		
		inputContainer.add(this.passwordLabel);
		inputContainer.add(this.passwordField);
		
		
		
		JPanel buttonContainer = new JPanel();
		buttonContainer.setLayout(new FlowLayout());
		buttonContainer.add(Box.createRigidArea(new Dimension(0,25)));
		
		buttonContainer.add(this.connexionButton);
		inputContainer.add(Box.createRigidArea(new Dimension(0,40)));
		buttonContainer.add(this.registerButton);
		
		
		
		
		view.add(inputContainer);
		view.add(buttonContainer);
		view.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));
		
		return view;
	}
	
	

}
