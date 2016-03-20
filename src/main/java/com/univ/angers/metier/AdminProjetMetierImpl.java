package com.univ.angers.metier;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.univ.angers.dao.ICrowdfundingDAO;
import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Contribution;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.User;

@Transactional
public class AdminProjetMetierImpl implements IAdminProjetMetier{
	
	private ICrowdfundingDAO daoAdminProjet;
	
	// setter
	public void setDaoAdminProjet(ICrowdfundingDAO daoAdminProjet) {
		this.daoAdminProjet = daoAdminProjet;
	}
	
	
	@Override
	public Long ajouterProjet(Projet p, Long idCat, Long idUser) {
		// TODO Auto-generated method stub
		return daoAdminProjet.ajouterProjet(p, idCat, idUser);
	}

	@Override
	public Projet contribuerProjet(Long idProjet, Long idUser, Contribution c) {
		// TODO Auto-generated method stub
		return daoAdminProjet.contribuerProjet(idProjet, idUser, c);
	}

	@Override
	public List<Projet> listprojets() {
		// TODO Auto-generated method stub
		return daoAdminProjet.listprojets();
	}

	@Override
	public List<Projet> projetsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return daoAdminProjet.projetsParMotCle(mc);
	}

	@Override
	public List<Projet> projetsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return daoAdminProjet.projetsParCategorie(idCat);
	}

	@Override
	public List<Projet> projet_A_finance() {
		// TODO Auto-generated method stub
		return daoAdminProjet.projet_A_finance();
	}

	@Override
	public List<Projet> listprojetsFinance() {
		// TODO Auto-generated method stub
		return daoAdminProjet.listprojetsFinance();
	}

	@Override
	public Projet getProjet(Long idP) {
		// TODO Auto-generated method stub
		return daoAdminProjet.getProjet(idP);
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return daoAdminProjet.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return daoAdminProjet.getCategorie(idCat);
	}

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerProjet(Long idP) {
		// TODO Auto-generated method stub
		daoAdminProjet.supprimerProjet(idP);
	}

	@Override
	public void modifierProjet(Projet p) {
		// TODO Auto-generated method stub
		daoAdminProjet.modifierProjet(p);
	}

}
