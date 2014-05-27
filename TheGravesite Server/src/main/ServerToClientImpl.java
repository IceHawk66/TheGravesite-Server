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
	
	@Override 
	public int[][] getAktiveMap(){
		return ebene.getAktiveMap(10, 15);
	}
	
	public void addSpieler(String name){
		main.addSpieler(name);
	}
	
	public void bewegeMap(int richtung){
		switch(richtung){
			case 1: ebene.Hoch();break;
			case 2: ebene.Runter();break;
			case 3: ebene.Links();break;
			case 4: ebene.Rechts();break;
		}
	}
	

}
