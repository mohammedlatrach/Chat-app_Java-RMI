package view.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import entities.User;
import server.Chat;
import view.login.Label;
import view.window.Window;

public class ChatView {
	
	// to delete upon finishing testing
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		
		
		
		new ChatView("d");
	}
	
	private String sessionId;
	Chat chatService;
	private JFrame chatWindow;
    private JTextArea messageDisplayArea;
    private JTextField messageInputField;
	
    private JList<String> userList;
    
	public ChatView(String sessionId) throws MalformedURLException, RemoteException, NotBoundException {
		this.sessionId=sessionId;
		try {
            this.chatService = (Chat) Naming.lookup("rmi://localhost:1099/remoteChatObject");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
		
		initUI();
	}
	
	
	private void initUI() {
        //chatWindow = new JFrame("Chat");
		chatWindow = new Window().getWindow();
        Container chatApp = chatWindow.getContentPane();
        chatApp.setLayout(new BorderLayout());
        //chatApp.setLayout(new BoxLayout(chatApp, BoxLayout.X_AXIS));

        // Message display area
        messageDisplayArea = new JTextArea(20, 40);
        messageDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageDisplayArea);

        // Message input area
        JPanel messageInputPanel = new JPanel();
        messageInputField = new JTextField(25);
        messageInputField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		messageInputField.setFont(new Font("Arial",Font.PLAIN,16));
		
        //JButton sendButton = new JButton("Send");
        SendButton sendButton = new SendButton("Send");
        
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
       
        messageInputPanel.add(messageInputField);
        messageInputPanel.add(sendButton);
        //messageInputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        messageInputPanel.setLayout(new BoxLayout(messageInputPanel,BoxLayout.X_AXIS));
        messageInputPanel.setBorder(BorderFactory.createEmptyBorder(3, 0, 4, 0));
        messageInputPanel.setPreferredSize(new Dimension(100, 50));

        //messageInputPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
        
        //user list
        JPanel userListPanel = new JPanel();
        userListPanel.setLayout(new BorderLayout());
        //userListPanel.setPreferredSize(new Dimension(100, 50));

        JLabel userListLabel = new Label().getLabel("Online Users:");
        userListPanel.add(userListLabel, BorderLayout.NORTH);
        userList = new JList<>();
        userListPanel.add(new JScrollPane(userList), BorderLayout.CENTER);
        
        
        
        chatApp.add(scrollPane, BorderLayout.CENTER);
        chatApp.add(messageInputPanel, BorderLayout.SOUTH);
        chatApp.add(userListPanel, BorderLayout.EAST);
        
        
        chatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatWindow.pack();
        chatWindow.setVisible(true);
    }

    private void sendMessage() {
        String message = messageInputField.getText();
        try {
            chatService.send(sessionId, message);
            //displayMessage("You: " + message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        messageInputField.setText("");
    }

    private void displayMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            messageDisplayArea.append(message + "\n");
            messageDisplayArea.setCaretPosition(messageDisplayArea.getDocument().getLength());
        });
    }
    
    public void receiveMessage(User sender,String message) {
        SwingUtilities.invokeLater(() -> {
            messageDisplayArea.append(sender.getFirstName() + " " + sender.getLastName() + " : " +message + "\n");
            messageDisplayArea.setCaretPosition(messageDisplayArea.getDocument().getLength());
        });
    }

}
