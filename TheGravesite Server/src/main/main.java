package main;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import Spielfiguren.Spieler;

public class main {

	private static LinkedList<Spieler> spielerliste;
	
	
	public static void main(String[] args) throws RemoteException {
		
		// Client Server Kommunikation initialisieren
		try{
			LocateRegistry.createRegistry( Registry.REGISTRY_PORT );
		}
		catch(java.rmi.server.ExportException e){
			LocateRegistry.getRegistry();
		}
		ServerToClientImpl ServerToClientImpl = new ServerToClientImpl();
		ServerToClient stub = (ServerToClient) UnicastRemoteObject.exportObject(ServerToClientImpl, 0 );
		
		RemoteServer.setLog( System.out );
		Registry registry = LocateRegistry.getRegistry();
		registry.rebind( "ServerToClient", stub );
		System.out.println( "ServerToClient angemeldet" );
		
		// LinkedList fuer Spieler initialisieren
		// TODO Abfrage ergaenzen, ob schon vorhanden (Textfile auslesen), ansonsten neu erstellen bei erstem Start
		
		spielerliste = new LinkedList<Spieler>();
	}
	
	public static void addSpieler(String name){
		spielerliste.add(new Spieler(name));
	}

}