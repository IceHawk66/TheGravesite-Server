package main;

import java.rmi.Remote;

import Ebene.Ebene;
import Spielfiguren.Spieler;
import main.main;

public class ServerToClientImpl implements ServerToClient, Remote{
	
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
	public int[][] getMap(){
		Ebene ebene = new Ebene(60,60);
		return ebene.getEbene();
	}
	
	public void addSpieler(String name){
		main.addSpieler(name);
	}
	
}
