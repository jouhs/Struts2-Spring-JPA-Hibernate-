package org.sid.service;

import java.util.List;

import org.sid.dao.IRepository;
import org.sid.entities.Produit;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CatalogueServiceImp implements IService<Produit> {
	private IRepository<Produit> dao;

	
	public void setDao(IRepository<Produit> dao) {
		this.dao = dao;
	}

	public void add(Produit t) {
		dao.add(t);

	}

	public List<Produit> findAll() {
		return dao.findAll();
	}

	public Produit getOne(String id) {
		return dao.getOne(id);
	}

	public void delete(String id) {
		dao.delete(id);

	}

	public void update(Produit t) {
		dao.update(t);

	}

}
