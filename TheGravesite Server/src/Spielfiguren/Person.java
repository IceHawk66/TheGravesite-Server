package Spielfiguren;

public abstract class Person {
	protected int maxhp;
	protected int hp;
	protected boolean lebt;
	
	protected void setMaxHp(int maxhp){
		this.maxhp = maxhp;
	}
	
	protected int getMaxHp(){
		return maxhp;
	}
	
	protected void setHp(int hp){
		this.hp = hp;
	}
	
	protected int getHp(){
		return hp;
	}
	
	protected void setLebt(boolean lebt){
		this.lebt = lebt;
	}
	
	protected boolean getLebt(){
		return lebt;
	}
}
