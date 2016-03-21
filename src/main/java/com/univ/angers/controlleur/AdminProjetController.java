package com.univ.angers.controlleur;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

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

import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.Projet;
import com.univ.angers.metier.IAdminProjetMetier;

@Controller
@RequestMapping(value="/adminProjet")
public class AdminProjetController {
	

	@Autowired
	@Qualifier("adminProjetMetier")
	private IAdminProjetMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("projet", new Projet());
		model.addAttribute("projets",metier.listprojets());
		model.addAttribute("categories", metier.listCategories());
		return "adminProjet";
	}
	

	@RequestMapping(value="/saveProjet")
	public String saveProjet(@Valid Projet p, BindingResult bindingRes,
			Model model, MultipartFile file) throws IOException{
		
		if(bindingRes.hasErrors()){
			model.addAttribute("projets", metier.listprojets());
			model.addAttribute("categories", metier.listCategories());
			return "adminProjet";
		}
		
		if(!file.isEmpty()){
			BufferedImage bi = ImageIO.read(file.getInputStream());
			p.setPhoto(file.getBytes());
			p.setNomPhoto(file.getOriginalFilename());
		}
		if(p.getIdProjet()!=null){
				if(file.isEmpty()){
					Projet photo = metier.getProjet(p.getIdProjet());
					p.setPhoto(photo.getPhoto());
				}
			
			metier.modifierProjet(p);
		}else{
			metier.ajouterProjet(p, p.getCategorie().getIdCategorie(), (long) 1);
		}
		model.addAttribute("projet", new Projet());
		model.addAttribute("projets", metier.listprojets());
		model.addAttribute("categories", metier.listCategories());

		return "adminProjet";
	}

	
	@RequestMapping(value="photoProj",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody //reponse envoyé directement dans le corps de la page
	public byte[] photoProj(Long idproj) throws IOException{
		Projet p = metier.getProjet(idproj);
		return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
	}
	
	
	@RequestMapping(value="/suppProj")
	public String suppProj(Long idProj, Model model){
		metier.supprimerProjet(idProj);
		model.addAttribute("projet", new Projet());
		model.addAttribute("projets", metier.listprojets());
		model.addAttribute("categories", metier.listCategories());

		return "adminProjet";
	}
	
	@RequestMapping(value="/editProj")
	public String edit(Long idProj, Model model){
		Projet p = metier.getProjet(idProj);

		model.addAttribute("projet", p);
		model.addAttribute("projets", metier.listprojets());
		model.addAttribute("categories", metier.listCategories());

		return "adminProjet";
	}
}
