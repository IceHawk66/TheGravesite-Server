package main;


import java.rmi.Remote;
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
		RawData rawdata = new RawData();
		InterfaceRawData stub = (InterfaceRawData) UnicastRemoteObject.exportObject(rawdata, 0 );
		
		RemoteServer.setLog( System.out );
		
		Registry registry = LocateRegistry.getRegistry();
		registry.rebind( "InterfaceRawData", stub );
		System.out.println( "InterfaceRawData angemeldet" );
	}
}