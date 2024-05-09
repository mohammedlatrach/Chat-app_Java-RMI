package Server;





import Client.ChatClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ChatServer extends UnicastRemoteObject implements ChatInterface {
    private final Map<ChatClientInterface, String> clients = new HashMap<>();

    public ChatServer() throws RemoteException {
        super();
    }

    @Override
    public synchronized void registerClient(ChatClientInterface client, String username) throws RemoteException {
        clients.put(client, username);
        sendMessage("Server", username + " has joined the chat.");
    }

    @Override
    public synchronized void unregisterClient(ChatClientInterface client, String username) throws RemoteException {
        clients.remove(client);
        sendMessage("Server", username + " has left the chat.");
    }

    @Override
    public synchronized void sendMessage(String username, String message) throws RemoteException {
        for (ChatClientInterface client : clients.keySet()) {
            client.receiveMessage(username + ": " + message);
        }
    }

    @Override
    public synchronized void sendPrivateMessage(String fromUser, String toUser, String message) throws RemoteException {
        boolean found = false;
        for (Map.Entry<ChatClientInterface, String> entry : clients.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(toUser)) {
                entry.getKey().receiveMessage("Private from " + fromUser + ": " + message);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RemoteException("User '" + toUser + "' not found.");
        }
    }
}