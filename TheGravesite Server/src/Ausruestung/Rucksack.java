package Ausruestung;

public class Rucksack {
	private Item[] rucksack;
	private boolean istVoll = false;
	private int groesse;
	
	public Rucksack(int groesse){
		this.setGroesse(groesse);
		rucksack = new Item[getGroesse()];
	}
	
	/**
	 * Fuegt ein Item an der ersten freien Stelle ein
	 * @param item
	 */
	public void fuegeItemEin(Item item){
		boolean found = false;
		while(!found){
			int i = 0;
			if(rucksack[i] == null){
				rucksack[i] = item;
				found = true;
			}
			i++;
		}
	}
	
	/**
	 * Loescht das uebergebene Item und entfernt die entstandene Luecke
	 * @param item
	 */
	public void loescheItem(Item item){

		// Item finden und löschen
		for(int i = 0; i < rucksack.length; i++){
			if(rucksack[i] == item){
				rucksack[i] = null;
			}
		}
		
		// Alle Items eins nach vorne bis Array keine Luecken mehr hat
		Item[] hilfsarray = new Item[rucksack.length];
		int j = 0;
		
		// noch nicht ueberprueft
		for(int i = 0; i < rucksack.length; i++){
			if(rucksack[i] != null){
				hilfsarray[j++] = rucksack[i];
			}
		}
	}

	public boolean isIstVoll() {
		return istVoll;
	}

	public void setIstVoll(boolean istVoll) {
		this.istVoll = istVoll;
	}

	public int getGroesse() {
		return groesse;
	}

	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}
	
}
