package Dao;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import modelo.Vehiculo;
@Stateless
public class VehiculoDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Vehiculo vehiculo) {
		em.persist(vehiculo);
	}
	
	public void update(Vehiculo vehiculo) {
		em.merge(vehiculo);
	}
	
	public Vehiculo read(int vehiculoId) {
		Vehiculo p = em.find(Vehiculo.class, vehiculoId);
		return p;
	}
	
	public void delete(int vehiculoId) {
		Vehiculo p = em.find(Vehiculo.class, vehiculoId);
		em.remove(p);
	}
	
	public List<Vehiculo> getAll(){
		String jpql = "SELECT p FROM Vehiculo p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}

}