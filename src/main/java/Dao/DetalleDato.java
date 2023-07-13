package Dao;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import modelo.FacturaDetalle;
@Stateless
public class DetalleDato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(FacturaDetalle detalle) {
		em.persist(detalle);
	}
	
	public void update(FacturaDetalle detalle) {
		em.merge(detalle);
	}
	
	public FacturaDetalle read(int detalleId) {
		FacturaDetalle p = em.find(FacturaDetalle.class, detalleId);
		return p;
	}
	
	public void delete(int detalleId) {
		FacturaDetalle p = em.find(FacturaDetalle.class, detalleId);
		em.remove(p);
	}
	
	public List<FacturaDetalle> getAll(){
		String jpql = "SELECT p FROM DetalleFactura p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
