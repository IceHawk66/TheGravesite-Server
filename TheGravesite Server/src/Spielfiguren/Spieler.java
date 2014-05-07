package Spielfiguren;

import Ausruestung.Rucksack;

public class Spieler extends Person{
	protected int level;
	protected int xp;
	protected int maxxp;
	protected Rucksack rucksack;
	protected String name;
	
	public Spieler(String name){
		this.name = name;
		rucksack = new Rucksack(5);
		level = 1;
		xp = 0;
		maxxp = 100;
		super.setLebt(true);
		super.setHp(100);
		super.setMaxHp(100);
	}
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
