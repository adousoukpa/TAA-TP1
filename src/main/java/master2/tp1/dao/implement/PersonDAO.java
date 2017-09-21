package master2.tp1.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import master2.tp1.dao.DAO;
import master2.tp1.domain.Person;

public class PersonDAO extends DAO<Person> {

	public PersonDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public boolean create(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person find(long id) {
		
		return manager.find(Person.class, id);
	}
	
	public List<Person> find (String name, String firstname) {
		Query req = manager.createQuery("SELECT p FROM Person p WHERE p.name = :name and p.firstname = :firstname")
				.setParameter("name", name)
				.setParameter("firstname", firstname);
		return req.getResultList();
	}
	
	public List<Person> findAll () {
		return manager.createQuery("SELECT p FROM Person p").getResultList();
	}

}
