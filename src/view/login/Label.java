package view.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Label {

	
	
	public static JLabel getLabel(String labelText) {
		
		
		JLabel label = new JLabel(labelText);
		label.setFont(new Font("Tahoma",Font.PLAIN,18));
		label.setForeground(Color.GRAY);
		
		return label;
	}

}
