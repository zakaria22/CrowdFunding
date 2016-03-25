package com.univ.angers.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.univ.angers.dao.ICrowdFundingDAO;
import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Commentaire;
import com.univ.angers.entities.Contribution;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.User;
import com.univ.angers.metier.IContributeurMetier;
@Transactional
public class ContributeurMetierImpl implements IContributeurMetier{

	private ICrowdFundingDAO dao;
	
	public void setDao(ICrowdFundingDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Projet> listprojets() {
		// TODO Auto-generated method stub
		return dao.listprojets();
	}

	@Override
	public List<Projet> projetsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.projetsParMotCle(mc);
	}

	@Override
	public List<Projet> projetsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.projetsParCategorie(idCat);
	}

	@Override
	public List<Projet> projet_A_finance() {
		// TODO Auto-generated method stub
		return dao.projet_A_finance();
	}

	@Override
	public List<Projet> listprojetsFinance() {
		// TODO Auto-generated method stub
		return dao.listprojetsFinance();
	}

	@Override
	public Projet getProjet(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProjet(idP);
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commentaire> listcommentaires(Long idP) {
		// TODO Auto-generated method stub
		return dao.listcommentaires(idP);
	}

	@Override
	public Long ajouterProjet(Projet p, Long idCat, Long idUser) {
		// TODO Auto-generated method stub
		return dao.ajouterProjet(p, idCat, idUser);
	}

	@Override
	public Contribution contribuerProjet(Long idProjet, Long idUser, Contribution c) {
		// TODO Auto-generated method stub
		return dao.contribuerProjet(idProjet, idUser, c);
	}

	@Override
	public Long ajouterCommentaire(Commentaire c, Long idP, Long idUser) {
		// TODO Auto-generated method stub
		return dao.ajouterCommentaire(c, idP, idUser);
	}

	@Override
	public User getUser(Long idUSer) {
		// TODO Auto-generated method stub
		return dao.getUser(idUSer);
	}

	@Override
	public List<User> listusers() {
		// TODO Auto-generated method stub
		return dao.listusers();
	}

	@Override
	public List<Projet> listUserProjets(Long idUSer) {
		// TODO Auto-generated method stub
		return dao.listUserProjets(idUSer);
	}

	@Override
	public List<Contribution> listUserContribution(Long idUSer) {
		// TODO Auto-generated method stub
		return dao.listUserContribution(idUSer);
	}

}
