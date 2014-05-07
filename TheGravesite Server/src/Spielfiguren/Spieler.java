package Spielfiguren;

public class Spieler extends Person{
	protected int level;
	protected int xp;
	protected int maxxp;
	
	protected void setLevel(int level){
		this.level = level;
	}
	
	protected int getLevel(){
		return level;
	}
	
	protected void setMaxXp(int maxxp){
		this.maxxp = maxxp;
	}
	
	protected int getMaxXp(){
		return maxxp;
	}
	
	protected void setXp(int xp){
		this.xp = xp;
	}
	
	protected int getMaxHp(){
		return xp;
	}
}
