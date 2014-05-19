package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRawData extends Remote{
	
	public String[][] getSpielerdaten() throws RemoteException;
	public int[][] getMap() throws RemoteException;
}