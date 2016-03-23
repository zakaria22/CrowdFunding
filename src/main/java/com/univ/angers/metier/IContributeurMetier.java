package com.univ.angers.metier;

import com.univ.angers.entities.Commentaire;
import com.univ.angers.entities.Contribution;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.User;

public interface IContributeurMetier extends InternauteMetier{

	public Long ajouterProjet(Projet p, Long idCat, Long idUser);
	public Projet contribuerProjet(Long idProjet,Long idUser,Contribution c);
	public Long ajouterCommentaire(Commentaire c, Long idP, Long idUser);
	public User getUser(Long idUSer);

}
