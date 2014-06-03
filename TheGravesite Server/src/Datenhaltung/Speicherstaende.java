package Datenhaltung;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import main.ServerToClientImpl;

import Ebene.Ebene;

/**
 * @author Jonas
 * 
 */
@Entity
public class Speicherstaende {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Ebene> speicherstand;

	// Defaultkonstruktor..
	public Speicherstaende() {
	}

	// Methode zum Hinzufügen eines Studenten
	public void addSpeicherstand(Ebene ebene) {
		speicherstand.add(ebene);
	}

	public List<Ebene> getSpeicherstand() {
		return speicherstand;
	}

	public void setSpeicherstand(LinkedList<Ebene> ebene) {
		this.speicherstand = ebene;
	}
}