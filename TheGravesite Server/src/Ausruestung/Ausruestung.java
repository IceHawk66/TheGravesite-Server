package Ausruestung;

public class Ausruestung extends ItemErsteller{
	private int att;
	private int def;
	
	public int getAtt() {
		return att;
	}
	
	public int getDef() {
		return def;
	}

	@Override
	protected void erzeugeItem() {
		items.add(new Weste("Kettenweste"));
	}
	
}
