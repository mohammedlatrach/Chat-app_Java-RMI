package view.window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window {

	//private JFrame window;
	
	public static JFrame getWindow() {
		JFrame window = new JFrame();
		window.setTitle("Chat app");
		window.setSize(400,600);
		window.setLocationRelativeTo(null);;
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("../Chat_app/src/chat.png");
		window.setIconImage(icon.getImage());
		//window.setOpacity(0.07f);
		/*window.setVisible(true);
		 * à mettre à la fin de l'appel ailleurs
		 */
		
		return window;
	}
	



}
