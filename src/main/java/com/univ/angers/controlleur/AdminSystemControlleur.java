package com.univ.angers.controlleur;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.univ.angers.entities.Categorie;
import com.univ.angers.metier.IAdminSystemMetier;

@Controller
@RequestMapping(value="/adminSystem")
public class AdminSystemControlleur {
	@Autowired
	private IAdminSystemMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		//pour la saisi d'une categ
		model.addAttribute("categorie",new Categorie());
		//pour afficher tt les categories
		model.addAttribute("categories",metier.listCategories());
		
		return "system";
	}
	
	@RequestMapping(value="/saveCategorie")
	public String saveCategorie(@Valid Categorie c,BindingResult bindingResult,
			Model  model,MultipartFile file ) throws IOException{
		//BindingResult pour gerer les erreurs de validation
		//MultipartFile pour le upload + ajouter des dependances
		//pour la saisi d'une categ
		
		//tester s'il y a des erreurs de validation
		if(bindingResult.hasErrors()){
			model.addAttribute("categories", metier.listCategories()); // pour lister les categories
			return("home");
		}
		
		//verifier si le fichier est vide
		if(!file.isEmpty()){
			//verifier que le fichier est une photo
			BufferedImage bi = ImageIO.read(file.getInputStream());
			
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
		}
		
		
		
		metier.ajouterCategorie(c);
		model.addAttribute("categorie",new Categorie());
		//pour afficher tt les categories
		model.addAttribute("categories",metier.listCategories());
		
		return "system";
	}
}
