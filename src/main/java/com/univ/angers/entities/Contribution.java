package com.univ.angers.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Contribution implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idContributeur;
	private int sommeDonnee;
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	@ManyToOne
	@JoinColumn(name="idProjet")
	private Projet projet;
	
	
}
