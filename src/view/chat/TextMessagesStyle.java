package view.chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class TextMessagesStyle extends JLabel{

	public TextMessagesStyle(String text) {

		this.setText(text);
		this.resize(this.preferredSize());
		this.setForeground(Color.BLACK);
		this.setFont(new Font("Segoe UI",Font.PLAIN,16));
		
		
	}


}
