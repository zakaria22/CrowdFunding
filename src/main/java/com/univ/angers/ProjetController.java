package com.univ.angers;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.univ.angers.entities.Projet;
import com.univ.angers.entities.User;
import com.univ.angers.metier.IAdminProjetMetier;

@Controller
@RequestMapping(value="/projet")
public class ProjetController {
	@Autowired
	@Qualifier("adminProjetMetier")
	private IAdminProjetMetier metier;
	
	@RequestMapping(value="/liste_projets")
	public String projets(Model model){
		model.addAttribute("projets",metier.listprojets());
		model.addAttribute("categories", metier.listCategories());
		return "projets";
	}
	
	@RequestMapping(value="/projet")
	public String projet(Long idproj, Model model){
		metier.getProjet(idproj);
		model.addAttribute("projet", metier.getProjet(idproj));
		model.addAttribute("categories", metier.listCategories());

		return "projet";
	}
	
	@RequestMapping(value="photoProj",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody //reponse envoyé directement dans le corps de la page
	public byte[] photoProj(Long idproj) throws IOException{
		Projet p = metier.getProjet(idproj);
		return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
	}
	

}
