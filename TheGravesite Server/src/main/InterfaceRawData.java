package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRawData extends Remote{
	
	public String[][] getSpielerdaten();
	public String[][] getMap();
}