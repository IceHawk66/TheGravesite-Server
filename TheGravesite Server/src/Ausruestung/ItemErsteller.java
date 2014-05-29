package Ausruestung;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemErsteller {
	protected List<AbstractItem> items = new ArrayList<AbstractItem>();
	
	public ItemErsteller(){
		this.erzeugeItem();
	}
	
	public List<AbstractItem> getItems(){
		return items;
	}
	
	protected abstract void erzeugeItem();
}
