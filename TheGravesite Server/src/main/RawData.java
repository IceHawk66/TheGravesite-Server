package main;

import java.rmi.Remote;

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
	public String[][] getMap(){
		String[][] map = new String[10][2];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				map[i][j] = "TestMap";
			}
		}
		return map;
	}
}
