package Client;

import Server.ChatInterface;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatClientGUI extends JFrame implements ChatClientInterface {

	@Override
	public void receiveMessage(String message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/*
	 * private final ChatInterface chatServer; private final String username;
	 * private JTextArea chatArea; private JTextField inputField; private JButton
	 * sendButton; private JList<String> userList;
	 * 
	 * public ChatClientGUI(String username, ChatInterface chatServer) throws
	 * RemoteException { this.chatServer = chatServer; this.username = username;
	 * 
	 * // Create GUI components chatArea = new JTextArea();
	 * chatArea.setEditable(false); JScrollPane scrollPane = new
	 * JScrollPane(chatArea);
	 * 
	 * inputField = new JTextField(30); sendButton = new JButton("Send");
	 * 
	 * JPanel inputPanel = new JPanel(); inputPanel.setLayout(new BorderLayout());
	 * inputPanel.add(inputField, BorderLayout.CENTER); inputPanel.add(sendButton,
	 * BorderLayout.EAST);
	 * 
	 * userList = new JList<>(); JScrollPane userScrollPane = new
	 * JScrollPane(userList);
	 * 
	 * JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
	 * scrollPane, userScrollPane); splitPane.setDividerLocation(350);
	 * 
	 * // Add components to the frame this.setLayout(new BorderLayout());
	 * this.add(splitPane, BorderLayout.CENTER); this.add(inputPanel,
	 * BorderLayout.SOUTH);
	 * 
	 * // Register action listeners sendButton.addActionListener(new
	 * SendMessageListener());
	 * 
	 * // Set up the frame this.setTitle("Chat - " + username); this.setSize(600,
	 * 400); this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * this.setVisible(true);
	 * 
	 * // Register with the chat server chatServer.registerClient(this, username); }
	 * 
	 * @Override public void receiveMessage(String message) throws RemoteException {
	 * chatArea.append(message + "\n"); }
	 * 
	 * private class SendMessageListener implements ActionListener {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { try { String message =
	 * inputField.getText(); if (message.trim().length() > 0) { if
	 * (message.startsWith("@")) { // Private message format: @username message int
	 * spaceIndex = message.indexOf(" "); if (spaceIndex > 0) { String targetUser =
	 * message.substring(1, spaceIndex); String privateMessage =
	 * message.substring(spaceIndex + 1); chatServer.sendPrivateMessage(username,
	 * targetUser, privateMessage); } else {
	 * chatArea.append("Invalid private message format.\n"); } } else {
	 * chatServer.sendMessage(username, message); } inputField.setText(""); } }
	 * catch (RemoteException ex) { ex.printStackTrace(); } } }
	 */
}
