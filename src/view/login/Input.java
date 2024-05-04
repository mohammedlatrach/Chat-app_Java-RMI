package view.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Input {


	public static JTextField getInput(String inputType) {
		
		
		JTextField input = null;
		if(inputType=="passwordInput") {
			input = new JPasswordField();
		}
		if(inputType=="textInput") {
			input = new JTextField();
		}
		
		input.setOpaque(false);
		input.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		input.setPreferredSize(new Dimension(350, 50));
		input.setFont(new Font("Courier New",Font.PLAIN,24));
		
		//icon part 
		input.setLayout(new BorderLayout());
		JLabel iconLabel = new JLabel(new ImageIcon(""));
		input.add(iconLabel, BorderLayout.WEST);
		
		return input;
	}

}
