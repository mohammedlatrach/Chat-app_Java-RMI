package view.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Input extends InputUI implements DocumentListener{

	private String inputValue;
	private JTextField input = null;
	
	
	public Input() {
		
		
		
		
		this.getDocument().addDocumentListener(this);
	}
	
	
	
	public void insertUpdate(DocumentEvent e) {
		this.setInputValue(this.getText());
		//System.out.println("the insert text is: " +this.getText());
	}
	
	public void removeUpdate(DocumentEvent e) {
		
		
	}
	
	
	
	public void changedUpdate(DocumentEvent e) {
		
		
	}
	
	
	public JTextField getInputComponent() {
		
		
		return this;
	}


	public String getInputValue() {
		return this.getText();
	}


	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	
}
