package Server;

import Client.ChatClientInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote {
    void sendMessage(String username, String message) throws RemoteException;
    void registerClient(ChatClientInterface client, String username) throws RemoteException;
    void unregisterClient(ChatClientInterface client, String username) throws RemoteException;
    
    void sendPrivateMessage(String fromUser, String toUser, String message) throws RemoteException;

}