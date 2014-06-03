package Ausruestung;

public class Hilfsmittel extends ItemErsteller{

	@Override
	protected void erzeugeItem() {
		items.add(new Key("Key"));
	}
}
