package Spielfiguren;

public class Gegner extends Person{
	private boolean sichtbar = true;

	public boolean getSichtbar() {
		return sichtbar;
	}

	public void setSichtbar(boolean sichtbar) {
		this.sichtbar = sichtbar;
	}
}
