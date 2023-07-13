package Dao;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import modelo.Empleado;

@Stateless
public class EmpleadoDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Empleado empleado) {
		em.persist(empleado);
	}
	
	public void update(Empleado empleado) {
		em.merge(empleado);
	}
	
	public Empleado read(Integer empleadoid) {
		Empleado p = em.find(Empleado.class, empleadoid);
		return p;
	}
	
	public void delete(Integer empleadoid) {
		Empleado p = em.find(Empleado.class, empleadoid);
		em.remove(p);
	}
	
	public List<Empleado> getAll(){
		String jpql = "SELECT p FROM Empleado p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}    
