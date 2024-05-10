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
		//this.setFont(new Font("Tahoma",Font.PLAIN,18));
		this.setForeground(Color.BLACK);
		this.setFont(new Font("Segoe UI",Font.PLAIN,16));
		//this.setPreferredSize(new Dimension(1, 1));
		/*this.setLineWrap(true); 
		this.setWrapStyleWord(true); 
		this.setPreferredSize(new Dimension(100, 1));
		this.setBorder(BorderFactory.createMatteBorder(1, 1 ,1 , 1, Color.GREEN));
		this.setEditable(false);
		this.setRows(20);*/
		
	}


}
