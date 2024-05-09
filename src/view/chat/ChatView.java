package view.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ChatView {

	public ChatView() {

	}

	public static JFrame getChatView() {
		
		JFrame chatWindow = ChatWindow.getChatWindow();
		
		
		Container chatApp = chatWindow.getContentPane();
		
		
		chatApp.setLayout(new BoxLayout(chatApp, BoxLayout.X_AXIS));
		
		
		//this is left
		JPanel chatHistory = new JPanel();
		//chatHistory.setBackground(Color.RED);
		
		//this center
		JPanel chatConversation = new JPanel();
		//chatConversation.setBackground(Color.GREEN);
		chatConversation.setLayout(new BorderLayout());
		
		
		JPanel messageInputArea = new JPanel();
		messageInputArea.setPreferredSize(new Dimension(100, 50));
		messageInputArea.setLayout(new BoxLayout(messageInputArea,BoxLayout.X_AXIS));
		
		JTextField messageInputField = new JTextField();
		messageInputField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		messageInputField.setFont(new Font("Arial",Font.PLAIN,16));
		
		
		
		SendButton sendButton = new SendButton("Send");
		
		
		//sendButton.setPreferredSize(new Dimension(50,50));
		
		messageInputArea.add(messageInputField);
		messageInputArea.add(sendButton);
		
		
		JPanel messagesDisplayArea = new JPanel();
		//JScrollPane scrollPane = new JScrollPane(messagesDisplayArea);
		
		
		
		
		
		chatConversation.add(messagesDisplayArea,BorderLayout.CENTER);
		chatConversation.add(messageInputArea,BorderLayout.SOUTH);
		//JTextField mesageInputArea = new JTextField();
		
		
		
		
		
		
		
		//this right
		JPanel chatInfos = new JPanel();
		//chatInfos.setBackground(Color.BLUE);
		
		
		chatApp.add(chatHistory);
		chatApp.add(chatConversation);
		chatApp.add(chatInfos);
		
		
		
		
		
		
		
		
		
		chatHistory.setPreferredSize(new Dimension(200, 200));
        chatInfos.setPreferredSize(new Dimension(200, 200));
        chatConversation.setPreferredSize(new Dimension(400, 200));
        
		
        chatConversation.setBorder(BorderFactory.createMatteBorder(0, 1 ,0 , 1, Color.BLUE));
        chatInfos.setBorder(BorderFactory.createMatteBorder(0, 1 ,0 , 0, Color.GREEN));
        chatHistory.setBorder(BorderFactory.createMatteBorder(0, 0 ,0 , 1, Color.GREEN));
        
        
		chatWindow.setVisible(true);
		
		
		return chatWindow;
	}

}
