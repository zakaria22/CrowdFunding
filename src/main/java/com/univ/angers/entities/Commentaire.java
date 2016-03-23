package com.univ.angers.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCommentaire;
	private String commentaire;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="idProjet")
	private Projet projet;
	
	public Long getIdCommentaire() {
		return idCommentaire;
	}
	public void setIdCommentaire(Long idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commentaire(String commentaire) {
		super();
		this.commentaire = commentaire;
	}
}
