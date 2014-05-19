package main;

import java.rmi.Remote;

import Ebene.Ebene;
import Spielfiguren.Spieler;
import main.main;

public class RawData implements InterfaceRawData, Remote{
	
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
		Ebene ebene = new Ebene(50,50);
		return ebene.getEbene();
	}
}
