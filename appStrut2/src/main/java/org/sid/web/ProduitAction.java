package org.sid.web;

import java.util.List;

import org.sid.dao.CatalogueDaoImpl;
import org.sid.dao.IRepository;
import org.sid.entities.Produit;

import com.opensymphony.xwork2.ActionSupport;

public class ProduitAction extends ActionSupport {
	public Produit produit = new Produit();
	public List<Produit> produits;
	public String ref = "0";
	public boolean editMode = false;
	private IRepository<Produit> service = new CatalogueDaoImpl();

	public String index() {
		produits = service.findAll();
		return SUCCESS;
	}

	public String save() {
		if (editMode == false)
			service.add(produit);
		else{
			service.update(produit);
			editMode = false;
			produit = new Produit();
		}
		produits = service.findAll();
		return SUCCESS;
	}

	public String edit() {
		editMode = true;
		service.getOne(ref);
		produits = service.findAll();
		return SUCCESS;
	}

	public String delete() {
		service.delete(ref);
		produits = service.findAll();
		return SUCCESS;
	}
}
