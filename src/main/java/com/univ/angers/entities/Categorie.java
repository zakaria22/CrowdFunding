package com.univ.angers.entities;

import java.io.Serializable;
import java.util.Collection;


public class Categorie implements Serializable{
	
	private Long idCategorie;
	private String nomCategorie;
	private String description;
	private byte[] photo;
	private String nomPhoto;
	private Collection<Projet> projets;
	public Long getId() {
		return idCategorie;
	}
	public void setId(Long id) {
		this.idCategorie = id;
	}
	public String getNom() {
		return nomCategorie;
	}
	public void setNom(String nom) {
		this.nomCategorie = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Collection<Projet> getProjets() {
		return projets;
	}
	public void setProjets(Collection<Projet> projets) {
		this.projets = projets;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String nom, String description, byte[] photo, String nomPhoto) {
		super();
		this.nomCategorie = nom;
		this.description = description;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
	}
	
	
	
}
