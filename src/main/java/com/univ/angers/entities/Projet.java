package com.univ.angers.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="projets")
public class Projet implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProjet;
	@NotEmpty
	@Size(min=4,max=15)
	private String designation;
	@NotEmpty
	@Size(min=4)
	private String description;
	private double budget;
	private double needed;
	private boolean financed;
	private int likes;
	@Lob
	private byte[] photo;
	private String nomPhoto;
	
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	@OneToMany(mappedBy="projet")
	private Collection<Contribution> contributions;
	
	@OneToMany(mappedBy="projet")
	private Collection<Commentaire> commentaire;
	
	
	public Collection<Commentaire> getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(Collection<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}
	public Long getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(Long idProjet) {
		this.idProjet = idProjet;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public double getNeeded() {
		return needed;
	}
	public void setNeeded(double needed) {
		this.needed = needed;
	}
	public boolean isFinanced() {
		return financed;
	}
	public void setFinanced(boolean financed) {
		this.financed = financed;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Collection<Contribution> getContributions() {
		return contributions;
	}
	public void setContributions(Collection<Contribution> contributions) {
		this.contributions = contributions;
	}
	public Projet(String designation, String description, double budget, double needed, boolean financed, int likes,
			byte[] photo, String nomPhoto) {
		super();
		this.designation = designation;
		this.description = description;
		this.budget = budget;
		this.needed = needed;
		this.financed = financed;
		this.likes = likes;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
	}
	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
}
