/**
 * 
 */
package Datenhaltung;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import main.ServerToClientImpl;

/**
 * @author Jonas
 *
 */
public class Datenhaltung {
	  private static final String PERSISTENCE_UNIT_NAME = "swt2Example";
	  private static EntityManagerFactory factory;
	/**
	 * @param args
	 */
	  public Datenhaltung() {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    EntityManager em = factory.createEntityManager();
		    //Beginn der Transaktion zur Speicherung der Hochschule
		    em.getTransaction().begin();
		    
		    Speicherstaende speicherstaende = new Speicherstaende();
		    speicherstaende.addSpeicherstand(main.ServerToClientImpl.getAlleEbenen());
		    //Auftrag an den EntityManager das Objekt fhDortmund zu persistieren
		    em.persist(speicherstaende);
		    //commiten der Transaktion
		    em.getTransaction().commit();    
		    // read the existing entries and write to console
		    Query q = em.createQuery("select t from Speicherstaende t");
		    Speicherstaende fhdo_loaded = (Speicherstaende) q.getSingleResult();
		    //Ausgabe der Studenten 
		    System.out.println(fhdo_loaded);
		    //EntityManager wird geschlossen
		    em.close();
		}

}