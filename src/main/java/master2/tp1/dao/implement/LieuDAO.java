package master2.tp1.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import master2.tp1.dao.DAO;
import master2.tp1.domain.Lieu;
import master2.tp1.domain.Person;

public class LieuDAO extends DAO<Lieu> {

	

	public LieuDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Lieu obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Lieu obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Lieu obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Lieu find(long id) {
		
		return manager.find(Lieu.class, id);
	}
	
	public List<Lieu> find (String name) {
		Query req = manager.createQuery("SELECT l FROM Lieu l WHERE l.name = :name")
				.setParameter("name", name);
		return req.getResultList();
	}
	
	public List<Person> findAll () {
		return manager.createQuery("SELECT l FROM Lieu l").getResultList();
	}

}
