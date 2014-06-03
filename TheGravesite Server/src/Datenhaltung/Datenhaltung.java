/**
 * 
 */
package swt2.examples.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import swt2.examples.jpa.entities.Hochschule;
import swt2.examples.jpa.entities.Student;

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
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    //Beginn der Transaktion zur Speicherung der Hochschule
	    em.getTransaction().begin();
	    //Erstellung einer neuen Hochschule und drei Studenten
	    Student stud1 = new Student("Rudi", "Roller", "Praktische Informatik");
	    Student stud2 = new Student("Rosa", "Schlüpfer", "Medizinische Informatik");
	    Student stud3 = new Student("Willi", "Wichtig", "Wirtschaftsinformatik");
	    Student stud4 = new Student("Axel", "Schweiß", "Softwaretechnik Dual");
	    Hochschule fhDortmund = new Hochschule("FH Dortmund");
	    fhDortmund.addStudent(stud1);
	    fhDortmund.addStudent(stud2);
	    fhDortmund.addStudent(stud3);
	    fhDortmund.addStudent(stud4);
	    //
	    //Auftrag an den EntityManager das Objekt fhDortmund zu persistieren
	    em.persist(fhDortmund);
	    //commiten der Transaktion
	    em.getTransaction().commit();    
	    // read the existing entries and write to console
	    Query q = em.createQuery("select t from Hochschule t");
	    Hochschule fhdo_loaded = (Hochschule) q.getSingleResult();
	    //Ausgabe der Studenten 
	    System.out.println(fhdo_loaded);
	    //EntityManager wird geschlossen
	    em.close();
	}

}
