package master2.tp1.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import master2.tp1.dao.DAO;
import master2.tp1.domain.Person;
import master2.tp1.domain.Sport;

public class SportDAO extends DAO<Sport> {


	public SportDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Sport obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Sport obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Sport obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sport find(long id) {
		
		return manager.find(Sport.class, id);
	}
	
	public List<Sport> find (String name) {
		Query req = manager.createQuery("SELECT s FROM Sport s WHERE s.name = :name")
				.setParameter("name", name);
		return req.getResultList();
	}
	
	public List<Sport> findNiveaux (int niveau) {
		Query req = manager.createQuery("SELECT s FROM Sport s WHERE s.niveau = :niveau")
				.setParameter("niveau", niveau);
		return req.getResultList();
	}
	
	public List<Sport> findAll () {
		return manager.createQuery("SELECT s FROM Sport s").getResultList();
	}

}
