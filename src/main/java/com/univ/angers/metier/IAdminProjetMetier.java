package com.univ.angers.metier;

import com.univ.angers.entities.Projet;

public interface IAdminProjetMetier extends IContributeurMetier{

	public void supprimerProjet(Long idP);
	public void modifierProjet(Projet p);
}
