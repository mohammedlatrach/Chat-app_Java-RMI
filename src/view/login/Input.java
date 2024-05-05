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

public class Input implements DocumentListener{

	private static String inputValue;
	private JTextField input = null;
	
	
	public Input(String inputType) {
		
		if(inputType=="passwordInput") {
			this.input = new JPasswordField();
		}
		if(inputType=="textInput") {
			this.input = new JTextField();
		}
		
		this.input.setOpaque(false);
		this.input.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		this.input.setPreferredSize(new Dimension(350, 50));
		this.input.setFont(new Font("Courier New",Font.PLAIN,24));
		
		/* icon part
		input.setLayout(new BorderLayout());
		JLabel iconLabel = new JLabel(new ImageIcon(""));
		input.add(iconLabel, BorderLayout.WEST);
		*/
		this.input.getDocument().addDocumentListener(this);
	}
	
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println("the insert event is: " + this.input.getText());
		
	}
	

	
}
