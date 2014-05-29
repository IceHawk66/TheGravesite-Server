package Ausruestung;

public abstract class AbstractItem {
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public AbstractItem(String name){
		this.name = name;
	}
}
