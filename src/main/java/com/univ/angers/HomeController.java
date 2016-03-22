package com.univ.angers;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Projet;
import com.univ.angers.entities.User;
import com.univ.angers.metier.InternauteMetier;


@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("internauteMetier")
	private InternauteMetier metier;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		model.addAttribute("categories", metier.listCategories());
		return "home";
	}
	
	@RequestMapping(value="/register")
	public String index(Model model){
		model.addAttribute("user",new User());
		return "registration";
	}
	
	@RequestMapping(value="photoCat",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody //reponse envoyé directement dans le corps de la page
	public byte[] photoCat(Long idCat) throws IOException{
		Categorie c= metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}
	
	@RequestMapping(value="/allProjects")
	public String allProjects(Model model){
		model.addAttribute("projets",metier.listprojets());
		return "allProjects";
	}
	
	@RequestMapping(value="photoProj",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody //reponse envoyé directement dans le corps de la page
	public byte[] photoProj(Long idproj) throws IOException{
		Projet p = metier.getProjet(idproj);
		return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
	}
	
	
	
}
