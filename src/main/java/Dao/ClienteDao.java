package Dao;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import modelo.Cliente;

@Stateless
public class ClienteDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
	}
	
	public Cliente read(Integer clienteid) {
		Cliente p = em.find(Cliente.class, clienteid);
		return p;
	}
	
	public void delete(Integer clienteid) {
		Cliente p = em.find(Cliente.class, clienteid);
		em.remove(p);
	}
	
	public List<Cliente> getAll(){
		String jpql = "SELECT p FROM Cliente p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
     
}
