package com.univ.angers.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	private String userName;
	private String password;
	private String adresse;
	private String email;
	private String tel;
	@Lob
	private byte[] photo;
	private String nomPhoto;
	
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
	@OneToMany(mappedBy="user")
	private Collection<Projet> projets;
	
	@OneToMany(mappedBy="user")
	private Collection<Commentaire> commentaire;
	
	@OneToMany(mappedBy="user")
	private Collection<Role> roles;
	
	
	@OneToMany(mappedBy="user")
	private Collection<Contribution> contributions;
	
	
	public Collection<Role> getRole() {
		return roles;
	}
	public void setRole(Collection<Role> roles) {
		this.roles = roles;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public Collection<Commentaire> getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(Collection<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Collection<Projet> getProjets() {
		return projets;
	}
	public void setProjets(Collection<Projet> projets) {
		this.projets = projets;
	}
	public Collection<Contribution> getContributions() {
		return contributions;
	}
	public void setContributions(Collection<Contribution> contributions) {
		this.contributions = contributions;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String password, String adresse, String email, String tel) {
		super();
		this.userName = userName;
		this.password = password;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	
	
}
