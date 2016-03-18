package com.univ.angers.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
