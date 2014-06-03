package Ausruestung;

public class Rucksack {
	private AbstractItem[] rucksack;
	private boolean istVoll = false;
	private int groesse;
	
	public Rucksack(int groesse){
		this.setGroesse(groesse);
		rucksack = new AbstractItem[getGroesse()];
	}
	
	/**
	 * Fuegt ein Item an der ersten freien Stelle ein
	 * @param item
	 */
	public void fuegeItemEin(AbstractItem item){
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
	public void loescheItem(AbstractItem item){

		// Item finden und löschen
		for(int i = 0; i < rucksack.length; i++){
			if(rucksack[i] == item){
				rucksack[i] = null;
			}
		}
		
		// Alle Items eins nach vorne bis Array keine Luecken mehr hat
		AbstractItem[] hilfsarray = new AbstractItem[rucksack.length];
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
