package authentication.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AuthenticationServer {

	public AuthenticationServer() {
	}

	public static void main(String[] args) throws RemoteException {
		
		AuthenticationImpl authenticationService = new AuthenticationImpl();
		
		
		Registry registry = LocateRegistry.createRegistry(1098);
		registry.rebind("authenticationService", authenticationService);
		
		System.out.println("Authentication server listen");
		
	}

}
