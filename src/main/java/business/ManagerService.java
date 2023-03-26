package business;

import java.util.List;
import javax.ejb.Local;

@Local
public interface ManagerService {
	
	public Object getById(Class table, Object id);
	
	public List<Object> getAll(Class table);
	
	public List<Object> getActives(Class table);
	
	public void create(Object entity);
	
	public void update(Object entity);
	
	public void remove(Object entity);
}