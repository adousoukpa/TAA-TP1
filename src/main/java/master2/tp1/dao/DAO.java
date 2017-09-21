package master2.tp1.dao;

import javax.persistence.EntityManager;

public abstract class DAO<T> {
	
	protected EntityManager manager;

	public DAO(EntityManager manager) {
		this.manager = manager;
	}

	public abstract boolean create(T obj);

	public abstract boolean delete(T obj);

	public abstract boolean update(T obj);
	
	public abstract T find (long id);
}
