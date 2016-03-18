package com.univ.angers.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;

@Entity
@Table(name="users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	private String userName;
	private String password;
	private boolean actived;
	private String adresse;
	private String email;
	private String tel;
	
	@OneToMany(mappedBy="user")
	private Collection<Projet> projets;
	
	@OneToMany(mappedBy="user")
	private Collection<Role> roles;
	
	@OneToMany(mappedBy="user")
	private Collection<Contribution> contributions;
	
	
	public Collection<Contribution> getContributions() {
		return contributions;
	}
	public void setContributions(Collection<Contribution> contributions) {
		this.contributions = contributions;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
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
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
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
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String password, boolean actived, String adresse, String email, String tel) {
		super();
		this.userName = userName;
		this.password = password;
		this.actived = actived;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	public User(String userName, String password, boolean actived) {
		super();
		this.userName = userName;
		this.password = password;
		this.actived = actived;
	}
	
}
