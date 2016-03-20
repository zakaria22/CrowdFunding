package com.univ.angers.metier;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.univ.angers.dao.ICrowdfundingDAO;
import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Contribution;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.User;

@Transactional
public class ContributeurMetierImpl implements IContributeurMetier{

	private ICrowdfundingDAO dao;
	
	// setter
	public void setDao(ICrowdfundingDAO dao) {
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
	public Long ajouterProjet(Projet p, Long idCat, Long idUser) {
		// TODO Auto-generated method stub
		return dao.ajouterProjet(p, idCat, idUser);
	}

	@Override
	public Projet contribuerProjet(Long idProjet, Long idUser, Contribution c) {
		// TODO Auto-generated method stub
		return dao.contribuerProjet(idProjet, idUser, c);
	}

}
