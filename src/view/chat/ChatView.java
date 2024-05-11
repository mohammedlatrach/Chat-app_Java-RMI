package view.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import entities.User;
import server.Chat;
import view.login.Label;

public class ChatView {
	
	// to delete upon finishing testing
	public static void main(String[] args) {
		
		
		
		
		//ChatView.getChatView();
	}
	
	private String sessionId;
	Chat chatService;
	
	public ChatView(String sessionId) throws MalformedURLException, RemoteException, NotBoundException {
		this.sessionId=sessionId;
		this.chatService = (Chat)Naming.lookup("rmi://localhost:1099/remoteChatObject");
	}
	
	

	public JFrame getChatView() throws MalformedURLException, RemoteException, NotBoundException {
		
		JFrame chatWindow = ChatWindow.getChatWindow();
		
		Container chatApp = chatWindow.getContentPane();
		chatApp.setLayout(new BoxLayout(chatApp, BoxLayout.X_AXIS));
		
		
		//this is left aside
		JPanel chatHistory = new JPanel();
		//chatHistory.setBackground(Color.RED);
		

		//this center CHHHHHHHHHHHHHHHHHHHHHHHHHH
		JPanel chatConversation = new JPanel();
		chatConversation.setLayout(new BorderLayout());
		
		
		
		
		JPanel messageDisplayArea = new JPanel();
		messageDisplayArea.setLayout(new BoxLayout(messageDisplayArea,  BoxLayout.Y_AXIS));
		
		
		//chatConversation.setLayout(new BoxLayout(chatConversation, BoxLayout.Y_AXIS));
		
		
		JPanel messageInputArea = new JPanel();
		messageInputArea.setPreferredSize(new Dimension(100, 50));
		messageInputArea.setLayout(new BoxLayout(messageInputArea,BoxLayout.X_AXIS));
		
		JTextField messageInputField = new JTextField();
		messageInputField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		messageInputField.setFont(new Font("Arial",Font.PLAIN,16));
		
		
		
		SendButton sendButton = new SendButton("Send");
		
		//implementing second phase
		
		
		
		
		messageInputArea.add(messageInputField);
		messageInputArea.add(sendButton);
		
		
		//JPanel messagesDisplayArea = new JPanel();
		
		
		
		
		
		//chatConversation.add(messagesDisplayArea,BorderLayout.CENTER);
		chatConversation.add(messageInputArea,BorderLayout.SOUTH);
		
		
		
		
		
		
		
		//this right aside
		JPanel chatInfos = new JPanel();
		
		
		chatApp.add(chatHistory);
		chatApp.add(chatConversation);
		chatApp.add(chatInfos);
		
		
		
		
		
		
		
		
		
		chatHistory.setPreferredSize(new Dimension(200, 200));
        chatInfos.setPreferredSize(new Dimension(200, 200));
        chatConversation.setPreferredSize(new Dimension(400, 200));
        
        
		
        chatConversation.setBorder(BorderFactory.createMatteBorder(0, 1 ,0 , 1, Color.BLUE));
        chatInfos.setBorder(BorderFactory.createMatteBorder(0, 1 ,0 , 0, Color.GREEN));
        chatHistory.setBorder(BorderFactory.createMatteBorder(0, 0 ,0 , 1, Color.GREEN));
        
        
      
        
        //Chat chatService = (Chat)Naming.lookup("rmi://localhost:1099/remoteChatObject");
        
        
        
        
        
        sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				messageDisplayArea.removeAll();
				chatWindow.revalidate();
				chatWindow.repaint();
				//messageDisplayArea.add(new TextMessagesStyle(messageInputField.getText()));
				
				try {
					ChatView.this.chatService.send(ChatView.this.sessionId,  messageInputField.getText(),messageDisplayArea);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					for(Map.Entry<User, String> entry :ChatView.this.chatService.getUserMessages().entrySet()) {
						User user = entry.getKey();
					    String message = entry.getValue();
					    messageDisplayArea.add(new TextMessagesStyle(user.getFirstName()+" "+user.getLastName() +" : "+message));
					    //System.out.println(user.getFirstName()+" "+user.getLastName() +" : "+message);
					}
					
						
						
					
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				chatWindow.revalidate();
				chatWindow.repaint();	
				
			}
        });
        
        /*
        sendButton.actionPerformed(e -> {
            messageDisplayArea.add(new TextMessagesStyle(messageInputField.getText()));
            chatWindow.revalidate();
            chatWindow.repaint();
            try {
                chatService.send("1", messageInputField.getText());
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });
        */
        
        chatConversation.add(new JScrollPane(messageDisplayArea), BorderLayout.CENTER);
        
		chatWindow.setVisible(true);
		
		
		return chatWindow;
	}

}
