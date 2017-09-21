package master2.tp1.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import master2.tp1.dao.implement.PersonDAO;
import master2.tp1.dao.implement.SportDAO;
import master2.tp1.domain.Lieu;
import master2.tp1.domain.Person;
import master2.tp1.domain.Sport;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		JpaTest test = new JpaTest(manager);

		try {
			test.createPersons();
			test.createLieux();
			test.createSports();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listPersons();
		test.listLieux();
		test.listSports();

		
		// PersonDAO
		PersonDAO testPersonDAO = new PersonDAO(manager);
		for (Person p : testPersonDAO.findAll()) {
			print(p);
		}
		
		print(testPersonDAO.find(1));
		print(testPersonDAO.find(454588));
		
		// LieuDAO
		
		// SportDAO
		SportDAO testSportDAO = new SportDAO(manager);
		for (Sport s : testSportDAO.findAll()) {
			System.out.println("heeeeeu "+s.getName());
			for (Lieu l: s.getLieux()) {
				System.out.println(l.getName());
			}
		}
		
		manager.close();
		factory.close();

		System.out.println(".. done.");
		
	}
	
	
	
	private void createPersons() {
        int numOfPersons = manager.createQuery("SELECT a FROM Person a", Person.class).getResultList().size();
        if (numOfPersons == 0) {
        	
        	Person p1 = new Person();
        	p1.setName("Soukpa");
        	p1.setFirstname("Adou");
        	
        	Person p2 = new Person();
        	p2.setName("Zbirka");
        	p2.setFirstname("Christophe");
        	
        	Person p3 = new Person();
        	p3.setName("Hussein");
        	p3.setFirstname("Waberi");
        	
        	
            manager.persist(p1);
            manager.persist(p2);
            manager.persist(p3);

        }
    }

    private void listPersons() {
        List<Person> resultList = manager.createQuery("SELECT a FROM Person a", Person.class).getResultList();
        System.out.println("num of persons:" + resultList.size());
        for (Person onePeople : resultList) {
            System.out.println("next employee: " + onePeople);
        }
    }

    private void createLieux() {
        int numOfLieux = manager.createQuery("SELECT a FROM Lieu a", Lieu.class).getResultList().size();
        if (numOfLieux == 0) {
        	
        	Lieu l1 = new Lieu();
        	l1.setName("Rennes");
        	
        	Lieu l2 = new Lieu();
        	l2.setName("Brest");
        	
        	Lieu l3 = new Lieu();
        	l3.setName("Quimper");
        	
        	
            manager.persist(l1);
            manager.persist(l2);
            manager.persist(l3);

        }
    }
    
    private void listLieux() {
        List<Lieu> resultList = manager.createQuery("SELECT a FROM Lieu a", Lieu.class).getResultList();
        System.out.println("num of places:" + resultList.size());
        for (Lieu place : resultList) {
            System.out.println("next pl	cz: " + place);
        }
    }
    
        private void createSports() {
        int numOfSports = manager.createQuery("SELECT a FROM Sport a", Sport.class).getResultList().size();
        if (numOfSports == 0) {
        	Sport s1 = new Sport();
        	s1.setName("Kayak");
        	
        	Sport s2 = new Sport();
        	s2.setName("Velo");
        	
        	Sport s3 = new Sport();
        	s3.setName("Equitation");
        	
        	
            manager.persist(s1);
            manager.persist(s2);
            manager.persist(s3);
        }
    }

    private void listSports() {
        List<Sport> resultList = manager.createQuery("SELECT a FROM Sport a", Sport.class).getResultList();
        System.out.println("num of sports:" + resultList.size());
        for (Sport next : resultList) {
            System.out.println("next sport: " + next);
        }
    }
    
    private static void print(Person p) {
    	if (p != null) {
    		System.out.println("id: " + p.getId() + " name: "+ p.getName() + " firstname: " + p.getFirstname());
		}
    }

}
