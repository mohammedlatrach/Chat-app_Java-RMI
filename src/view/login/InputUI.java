package view.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class InputUI extends JTextField{

	public InputUI() {
		this.setOpaque(false);
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		this.setPreferredSize(new Dimension(350, 50));
		this.setFont(new Font("Courier New",Font.PLAIN,24));
		
	}

}
