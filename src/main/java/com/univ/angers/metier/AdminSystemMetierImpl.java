package com.univ.angers.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.univ.angers.dao.ICrowdFundingDAO;
import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Commentaire;
import com.univ.angers.entities.Contribution;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.User;
@Transactional
public class AdminSystemMetierImpl implements IAdminSystemMetier{

	private ICrowdFundingDAO daoAdminSystem;
	
	
	public void setDaoAdminSystem(ICrowdFundingDAO daoAdminSystem) {
		this.daoAdminSystem = daoAdminSystem;
	}

	@Override
	public void supprimerProjet(Long idP) {
		// TODO Auto-generated method stub
		daoAdminSystem.supprimerProjet(idP);
	}

	@Override
	public void modifierProjet(Projet p) {
		// TODO Auto-generated method stub
		daoAdminSystem.modifierProjet(p);
	}

	@Override
	public Long ajouterProjet(Projet p, Long idCat, Long idUser) {
		// TODO Auto-generated method stub
		return daoAdminSystem.ajouterProjet(p, idCat, idUser);
	}

	@Override
	public Contribution contribuerProjet(Long idProjet, Long idUser, Contribution c) {
		// TODO Auto-generated method stub
		return daoAdminSystem.contribuerProjet(idProjet, idUser, c);
	}

	@Override
	public List<Projet> listprojets() {
		// TODO Auto-generated method stub
		return daoAdminSystem.listprojets();
	}

	@Override
	public List<Projet> projetsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return daoAdminSystem.projetsParMotCle(mc);
	}

	@Override
	public List<Projet> projetsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return daoAdminSystem.projetsParCategorie(idCat);
	}

	@Override
	public List<Projet> projet_A_finance() {
		// TODO Auto-generated method stub
		return daoAdminSystem.projet_A_finance();
	}

	@Override
	public List<Projet> listprojetsFinance() {
		// TODO Auto-generated method stub
		return daoAdminSystem.listprojetsFinance();
	}

	@Override
	public Projet getProjet(Long idP) {
		// TODO Auto-generated method stub
		return daoAdminSystem.getProjet(idP);
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return daoAdminSystem.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return daoAdminSystem.getCategorie(idCat);
	}

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commentaire> listcommentaires(Long idP) {
		// TODO Auto-generated method stub
		return daoAdminSystem.listcommentaires( idP);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return daoAdminSystem.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		// TODO Auto-generated method stub
		daoAdminSystem.supprimerCategrorie(idcat);
	}


	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		daoAdminSystem.modifierCategorie(c);
	
	}

	@Override
	public Long ajouterCommentaire(Commentaire c, Long idP, Long idUser) {
		// TODO Auto-generated method stub
		return daoAdminSystem.ajouterCommentaire(c, idP, idUser);
	}

	@Override
	public User getUser(Long idUSer) {
		// TODO Auto-generated method stub
		return daoAdminSystem.getUser(idUSer);
	}

	@Override
	public List<User> listusers() {
		// TODO Auto-generated method stub
		return daoAdminSystem.listusers();
	}

}
