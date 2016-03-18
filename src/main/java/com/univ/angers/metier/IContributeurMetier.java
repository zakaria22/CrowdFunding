package com.univ.angers.metier;

import com.univ.angers.entities.Contribution;
import com.univ.angers.entities.Projet;

public interface IContributeurMetier extends InternauteMetier{

	public Long ajouterProjet(Projet p, Long idCat, Long idUser);
	public Projet contribuerProjet(Long idProjet,Long idUser,Contribution c);

}
