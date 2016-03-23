package com.univ.angers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.univ.angers.entities.Categorie;
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
		model.addAttribute("commentaires", metier.listcommentaires());

		return "projet";
	}
	
	
	
	@RequestMapping(value="photoUser",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody //reponse envoyé directement dans le corps de la page
	public byte[] photoUser(Long idUsr) throws IOException{
		User u = metier.getUser(idUsr);
		return IOUtils.toByteArray(new ByteArrayInputStream(u.getPhoto()));
	}
	
	
	@RequestMapping(value="/projetParCat")
	public String index(Long idCat,Model model){
		List<Projet> p = metier.projetsParCategorie(idCat);
		if(p.size()!=0){
			model.addAttribute("projets",metier.projetsParCategorie(idCat));
			model.addAttribute("categories", metier.listCategories());
			return "projectByCategories";
		}
		else{
			model.addAttribute("categories", metier.listCategories());

			return "404";
		}
	}
	
	@RequestMapping(value="photoProj",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody //reponse envoyé directement dans le corps de la page
	public byte[] photoProj(Long idproj) throws IOException{
		Projet p = metier.getProjet(idproj);
		return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
	}
	
	@RequestMapping(value="/add")
	public String add(Model model){
		model.addAttribute("addProjet",new Projet());
		model.addAttribute("categories", metier.listCategories());
		return "addProjet";
	}
	
	@RequestMapping(value="/saveNewProjet")
	public ModelAndView save(@Valid Projet p, BindingResult bindingRes,
			Model model, MultipartFile file) throws IOException{
		
		if(bindingRes.hasErrors()){
			model.addAttribute("addProjet",new Projet());
			return new ModelAndView("redirect:" + "/add");
		}
		
		if(!file.isEmpty()){
			BufferedImage bi = ImageIO.read(file.getInputStream());
			p.setPhoto(file.getBytes());
			p.setNomPhoto(file.getOriginalFilename());
		}
		
		metier.ajouterProjet(p, p.getCategorie().getIdCategorie(), (long) 2);
		
		model.addAttribute("categories", metier.listCategories());
		return new ModelAndView("redirect:" + "/projet/projet");

	}

	@RequestMapping(value="/edit")
	public String edit(Long idP, Model model){
		Projet p = metier.getProjet(idP);
		model.addAttribute("projet",p);
		model.addAttribute("categories", metier.listCategories());
		return "addProjet";
	}
	

	@RequestMapping(value="/supp")
	public ModelAndView suppProj(Long idP, Model model){
		metier.supprimerProjet(idP);
		return new ModelAndView("redirect:" + "/");
	}
}
