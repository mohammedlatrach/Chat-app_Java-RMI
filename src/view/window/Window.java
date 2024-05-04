package view.window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window {

	
	public static JFrame getWindow() {
		JFrame window = new JFrame();
		window.setTitle("Chat app");
		window.setSize(400,600);
		window.setLocationRelativeTo(null);;
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("../Chat_app/src/chat.png");
		
		return window;
	}
	



}
