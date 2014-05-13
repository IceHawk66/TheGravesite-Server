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

	private static LinkedList<Spieler> spieler;
	
	public static void main(String[] args) throws RemoteException {
		
		// Client Server Kommunikation initialisieren
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
		
		// LinkedList fuer Spieler initialisieren
		// TODO Abfrage ergaenzen, ob schon vorhanden (Textfile auslesen), ansonsten neu erstellen bei erstem Start
		
		spieler = new LinkedList<Spieler>();
	}
	
	public static void fuegeSpielerhinzu(Spieler s){
		spieler.add(s);
	}
}