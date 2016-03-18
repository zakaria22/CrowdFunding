package com.univ.angers.metier;

import com.univ.angers.entities.Projet;

public interface IAdminProjetMetier extends InternauteMetier{

	public Long ajouterProjet(Projet p, Long idCat, Long idUser);
	public void supprimerProjet(Long idP);
	public void modifierProjet(Projet p);

}
