package com.univ.angers.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.univ.angers.dao.ICrowdFundingDAO;
import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Commentaire;
import com.univ.angers.entities.Contribution;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.Role;
import com.univ.angers.entities.User;

@Transactional
public class CrowdFundingImpl implements ICrowdFundingDAO{

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
	public Projet getProjet(Long idP) {
		return em.find(Projet.class, idP);
	}

	@Override
	public void supprimerProjet(Long idP) {
		Projet p=em.find(Projet.class, idP);
		 em.remove(p);
		
	}

	@Override
	public void modifierProjet(Projet p) {
		em.merge(p);
		
	}

	@Override
	public Contribution contribuerProjet(Long idProjet, Long idUser, Contribution c) {
		Projet p = getProjet(idProjet);
		User u = em.find(User.class, idUser);
		c.setProjet(p);
		c.setUser(u);
		p.setNeeded(p.getNeeded()-c.getSommeDonnee());
		if(p.getNeeded()==0){
			p.setFinanced(true);
		}
		em.merge(p);
		em.persist(c);
		return c;
	}


	@Override
	public void register(User u) {
		em.persist(u);
	}

	@Override
	public List<User> listusers() {
		Query req=em.createQuery("select u from User u");
		return req.getResultList();
	}
	
	@Override
	public Long ajouterProjet(Projet p, Long idCat, Long idUser) {
		Role r = new Role("ADMIN_PROJET");
		Categorie c = getCategorie(idCat);
		User u = em.find(User.class, idUser);
		r.setProjet(p);
		r.setUser(u);
		p.setCategorie(c);
		p.setUser(u);
		em.persist(r);
		em.persist(p);
		return p.getIdProjet();
	}
	
	
	@Override
	public Long ajouterCommentaire(Commentaire c, Long idP, Long idUser) {

		Projet p = em.find(Projet.class, idP);
		User u = em.find(User.class, idUser);
		c.setProjet(p);
		c.setUser(u);
		em.persist(c);
		return c.getIdCommentaire();
	}

	@Override
	public List<Commentaire> listcommentaires(Long idP) {
		Query req=em.createQuery("select c from Commentaire c where c.projet.idProjet=:x");
		req.setParameter("x", idP);

		return req.getResultList();
	}

	@Override
	public User getUser(Long idUSer) {
		// TODO Auto-generated method stub
		return em.find(User.class, idUSer);
	}

	@Override
	public List<Projet> listUserProjets(Long idUSer) {
		Query req=em.createQuery("select p from Projet p where p.user.idUser like :x");
		req.setParameter("x", idUSer);
		return req.getResultList();
	}

	@Override
	public List<Contribution> listUserContribution(Long idUSer) {
		
		
		Query req=em.createQuery("select c from Contribution c where c.user.idUser = :x");
		req.setParameter("x", idUSer);
		return req.getResultList();
	}

}
