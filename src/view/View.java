package view;

import javax.swing.JFrame;

import view.window.Window;

public class View {

	public View() {

	}

	public static void main(String[] args) {
		
		
		
		JFrame window = Window.getWindow();
		
		//puis ça doit être window.add(header);
		//puis ça doit être window.add(main);
		//puis ça doit être window.add(footer);
		//mais je ne sais pas le type d'objet que va être ces objets, header,main & footer
	}

}
