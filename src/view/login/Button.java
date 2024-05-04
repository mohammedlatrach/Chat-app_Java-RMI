package view.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class Button {

	
	public static JButton getButton(String buttonText) {
		
		
		JButton button = new JButton(buttonText);
		
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(52, 152, 219));
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setPreferredSize(new Dimension(200, 30));
		
		return button;
		
	}

}
