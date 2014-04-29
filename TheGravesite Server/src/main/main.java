package main;
import Adder;
import AdderImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

public class main {

	public static void main(String[] args) throws RemoteException {
		try{
			LocateRegistry.createRegistry( Registry.REGISTRY_PORT );
		}
		catch(java.rmi.server.ExportException e){
			LocateRegistry.getRegistry();
		}
		AdderImpl adder = new AdderImpl();
		Adder stub = (Adder) UnicastRemoteObject.exportObject( adder, 0 );
		
		RemoteServer.setLog( System.out );
		
		Registry registry = LocateRegistry.getRegistry();
		registry.rebind( "Adder", stub );
		System.out.println( "Adder angemeldet" );
	}
}
