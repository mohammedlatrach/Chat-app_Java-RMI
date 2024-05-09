package Server;



import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ChatServerMain {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Default RMI port
            ChatServer chatServer = new ChatServer();
            Naming.rebind("rmi://localhost/ChatServer", chatServer);
            System.out.println("Chat server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}