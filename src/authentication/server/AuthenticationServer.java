package authentication.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AuthenticationServer {

	public AuthenticationServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws RemoteException {
		
		AuthenticationImpl authenticationService = new AuthenticationImpl();
		
		
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("authenticationService", authenticationService);
		
		System.out.println("Authentication server listen");
		
	}

}
