package view.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Input implements ActionListener{

	private static String inputValue;
	
	
	
	
	
	public static JTextField getInput(String inputType) {
		
		
		JTextField input = null;
		if(inputType=="passwordInput") {
			input = new JPasswordField();
		}
		if(inputType=="textInput") {
			input = new JTextField();
		}
		
		input.setOpaque(false);
		input.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		input.setPreferredSize(new Dimension(350, 50));
		input.setFont(new Font("Courier New",Font.PLAIN,24));
		
		
		//icon part 
		input.setLayout(new BorderLayout());
		JLabel iconLabel = new JLabel(new ImageIcon(""));
		input.add(iconLabel, BorderLayout.WEST);
		
		//for events
		//input.addActionListener(new Input());
		input.getDocument().addDocumentListener(new InputDocumentListener(input));


		//testing if input is inserted 
		input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions when the event occurs
                System.out.println("this.inputValue : "+ inputValue);
            }
        });
		return input;
	}

	
	
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("The event 22222: "+e);
		
	}
	
	private static class InputDocumentListener implements DocumentListener {
        private JTextField textField;
        private String inputValue;
        
        public InputDocumentListener(JTextField textField) {
            this.textField = textField;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            // Perform actions when text is inserted
            //System.out.println("the insert event is: " + textField.getText());
        	((Input)textField.getClientProperty("parent")).inputValue = textField.getText();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            // Perform actions when text is removed
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Perform actions when text attributes are changed
        }
    }
	
}
