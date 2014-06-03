package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Ebene.Ebene;
import Spielfiguren.Spieler;
import main.main;

public class ServerToClientImpl implements ServerToClient, Remote{
	
	private Ebene ebene = new Ebene();
	
	@Override 
	public String[][] getSpielerdaten(){
		String[][] spielerdaten = new String[10][2];
		for(int i = 0; i < spielerdaten.length; i++){
			for(int j = 0; j < spielerdaten[0].length; j++){
				spielerdaten[i][j] = "Test";
			}
		}
		return spielerdaten;
	}
	
	@Override // TODO Parameter ergänzen
	public int[][] getSichtfeld(){
		return ebene.getSichtfeld(10, 15);
	}
	
	public void addSpieler(String name){
		main.addSpieler(name);
	}
	
	public void bewegeMap(int richtung){
		switch(richtung){
			case 1: ebene.hoch();break;
			case 2: ebene.runter();break;
			case 3: ebene.links();break;
			case 4: ebene.rechts();break;
		}
	}
	
	public void erstelleNeueMap(){
		ebene = new Ebene();
	}

	@Override
	public int getSpielerX() throws RemoteException {
		return ebene.getSpielerX();
	}

	@Override
	public int getSpielerY() throws RemoteException {
		return ebene.getSpielerY();
	}

	@Override
	public int[][] getAktiveMap() throws RemoteException {
		return ebene.getAktiveMap();
	}
	
	public Ebene getAlleEbenen(){
		return ebene;
	}
}
