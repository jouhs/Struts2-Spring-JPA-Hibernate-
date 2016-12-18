package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Produit;

public class CatalogueDaoImpl implements IRepository<Produit> {

	@PersistenceContext
	private EntityManager em;
	public void add(Produit t) {
		em.persist(t);
		
	}

	public List<Produit> findAll() {
		Query req=em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	public Produit getOne(String id) {
		return em.find(Produit.class, id);
	}

	public void delete(String id) {
		Produit p = getOne(id);
		em.remove(p);	
		
	}

	public void update(Produit t) {
		em.merge(t);
		
	}

}
