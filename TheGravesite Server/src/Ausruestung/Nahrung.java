package Ausruestung;

public class Nahrung extends ItemErsteller{
	private int hp;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	protected void erzeugeItem() {
		items.add(new Wasserflasche("Soda"));
	}
}
