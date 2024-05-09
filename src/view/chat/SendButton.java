package view.chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class SendButton extends JButton{

	public SendButton(String text) {
		this.setText(text);
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(52, 152, 219));
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setFont(new Font("Arial", Font.BOLD, 14));
		this.setMaximumSize(new Dimension(Short.MAX_VALUE, 50));
	}

}
