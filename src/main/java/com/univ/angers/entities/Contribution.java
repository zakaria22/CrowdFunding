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
	public Long getIdContributeur() {
		return idContributeur;
	}
	public void setIdContributeur(Long idContributeur) {
		this.idContributeur = idContributeur;
	}
	public int getSommeDonnee() {
		return sommeDonnee;
	}
	public void setSommeDonnee(int sommeDonnee) {
		this.sommeDonnee = sommeDonnee;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Contribution() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contribution(int sommeDonnee) {
		super();
		this.sommeDonnee = sommeDonnee;
	}
	
	
}
