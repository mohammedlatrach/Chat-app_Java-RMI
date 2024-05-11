package view.chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SendButton extends JButton implements ActionListener{

	public SendButton(String text) {
		this.setText(text);
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(52, 152, 219));
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setFont(new Font("Arial", Font.BOLD, 14));
		this.setMaximumSize(new Dimension(Short.MAX_VALUE, 50));
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
