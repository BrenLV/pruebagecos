package business;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import common.ToolException;

@Stateless
public class ManagerServiceImpl implements ManagerService {

	@PersistenceContext(unitName = "exampleContext")
	private EntityManager manager;

	public Object getById(Class table, Object id) {
		return manager.find(table, id);
	}

	public List<Object> getAll(Class table) {
		Query query = manager.createQuery("SELECT q FROM " + table.getSimpleName() +" q ");
		return query.getResultList();
	}
	
	public List<Object> getActives(Class table) {
		Query query = manager.createQuery("SELECT q FROM " + table.getSimpleName() +" q WHERE q.active = true ");
		return query.getResultList();
	}

	public void create(Object entity) {
		manager.persist(entity);
	}

	public void update(Object entity) {
		manager.merge(entity);
	}

	public void remove(Object entity) {
		manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
	}
}