package view.chat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ChatWindow {

	public ChatWindow() {
		// TODO Auto-generated constructor stub
	}

	public static JFrame getChatWindow() {
		JFrame window = new JFrame();
		window.setTitle("Chat app");
		window.setSize(800,500);
		window.setLocationRelativeTo(null);;
		ImageIcon icon = new ImageIcon("../Chat_app/src/chat.png");
		window.setIconImage(icon.getImage());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.setVisible(true);
		
		return window;
	}
}
