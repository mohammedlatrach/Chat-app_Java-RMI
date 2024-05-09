package Client;

import Server.ChatInterface;
import java.rmi.Naming;
import java.util.Scanner;

public class ChatClientMain {
    public static void main(String[] args) {
       try {
            // Connect to the server
            ChatInterface chatServer = (ChatInterface) Naming.lookup("rmi://localhost/ChatServer");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            // Register the client with the server
            ChatClient chatClient = new ChatClient();
            chatServer.registerClient(chatClient, username);

            System.out.println("Type your messages. Use '@username message' for private messages.");
            System.out.println("Type 'exit' to leave.");

            // Handle user input for general and private messages
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("exit")) {
                if (input.startsWith("@")) {
                    // Private message
                    int spaceIndex = input.indexOf(" ");
                    if (spaceIndex > 0) {
                        String targetUser = input.substring(1, spaceIndex);
                        String message = input.substring(spaceIndex + 1);
                        chatServer.sendPrivateMessage(username, targetUser, message);
                    } else {
                        System.out.println("Invalid private message format.");
                    }
                } else {
                    // General message
                    chatServer.sendMessage(username, input);
                }
            }

            // Unregister the client when exiting
            chatServer.unregisterClient(chatClient, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	/*
        try {
            ChatInterface chatServer = (ChatInterface) Naming.lookup("rmi://localhost/ChatServer");

            // Get the username from a dialog box
            String username = JOptionPane.showInputDialog("Enter your username:");

            if (username != null && !username.trim().isEmpty()) {
                new ChatClientGUI(username, chatServer);
            } else {
                System.out.println("Username cannot be empty. Exiting.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        
        
        
    }
}
