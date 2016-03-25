package com.univ.angers.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.univ.angers.dao.ICrowdFundingDAO;
import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Commentaire;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.User;


@Transactional
public class InternauteMetierImpl implements InternauteMetier{

	private ICrowdFundingDAO daoInternaute;

	public void setDaoInternaute(ICrowdFundingDAO daoInternaute) {
		this.daoInternaute = daoInternaute;
	}

	@Override
	public List<Projet> listprojets() {
		// TODO Auto-generated method stub
		return daoInternaute.listprojets();
	}

	@Override
	public List<Projet> projetsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return daoInternaute.projetsParMotCle(mc);
	}

	@Override
	public List<Projet> projetsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return daoInternaute.projetsParCategorie(idCat);
	}

	@Override
	public List<Projet> projet_A_finance() {
		// TODO Auto-generated method stub
		return daoInternaute.projet_A_finance();
	}

	@Override
	public List<Projet> listprojetsFinance() {
		// TODO Auto-generated method stub
		return daoInternaute.listprojetsFinance();
	}

	@Override
	public Projet getProjet(Long idP) {
		// TODO Auto-generated method stub
		return daoInternaute.getProjet(idP);
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return daoInternaute.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return daoInternaute.getCategorie(idCat);
	}

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		daoInternaute.register(u);
	}

	@Override
	public List<Commentaire> listcommentaires(Long idP) {
		// TODO Auto-generated method stub
		return daoInternaute.listcommentaires( idP);
	}
	
	
}
