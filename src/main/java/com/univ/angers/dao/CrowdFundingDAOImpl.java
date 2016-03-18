package com.univ.angers.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Contribution;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.Role;
import com.univ.angers.entities.User;

public class CrowdFundingDAOImpl implements ICrowdfundingDAO{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		Query req=em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		return em.find(Categorie.class, idCat);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		Categorie c = em.find(Categorie.class, idcat);
		em.remove(c);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);
	}


	@Override
	public List<Projet> listprojets() {
		Query req=em.createQuery("select p from Projet p");
		return req.getResultList();
	}

	@Override
	public List<Projet> projetsParMotCle(String mc) {
		Query req=em.createQuery("select p from Projet p where p.designation like :x or p.description like :x");
		req.setParameter("x", "%"+mc+"%");//"%"+mc+"%" :> qlqsoit la position du mot clé
		return req.getResultList();
	}

	@Override
	public List<Projet> projetsParCategorie(Long idCat) {
		Query req=em.createQuery("select p from Projet p where p.categorie.idCategorie=:x");
		req.setParameter("x", idCat);
		return req.getResultList();
	}

	@Override
	public List<Projet> projet_A_finance() {
		Query req=em.createQuery("select p from Projet p where p.financed=false");
		return req.getResultList();
	}

	@Override
	public List<Projet> listprojetsFinance() {
		Query req=em.createQuery("select p from Projet p where p.financed=true");
		return req.getResultList();
	}

	@Override
	public Long ajouterProjet(Projet p, Long idCat, Long idUser) {
		Categorie c = getCategorie(idCat);
		User u = em.find(User.class, idUser);
		p.setCategorie(c);
		p.setUser(u);
		em.persist(p);
		return p.getIdProjet();
	}
	
	@Override
	public Projet getProjet(Long idP) {
		// TODO Auto-generated method stub
		return em.find(Projet.class, idP);
	}

	@Override
	public void supprimerProjet(Long idP) {
		Projet p=getProjet(idP);
		em.remove(p);
	}

	@Override
	public void modifierProjet(Projet p) {
		em.merge(p);
		
	}


	@Override
	public void attribuerRole(Role r, Long userID) {
		User u = em.find(User.class, userID);
		u.getRoles().add(r);
		em.persist(r);
	}

	

	@Override
	public void ajouterUserAdmin(User u) {
		// TODO Auto-generated method stub
		em.persist(u);
	}

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		em.persist(u);
	}


	@Override
	public void contribuerProjet(Long idProjet, Long idUser, Contribution c) {
		Projet p = getProjet(idProjet);
		User u = em.find(User.class, idUser);
		c.setProjet(p);
		c.setUser(u);
		em.persist(c);
	}

}
