package com.univ.angers.controlleur;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.univ.angers.entities.Categorie;
import com.univ.angers.metier.IAdminSystemMetier;

@Controller
@RequestMapping(value="/adminSystem")
public class AdminSystemController implements HandlerExceptionResolver{
	@Autowired
	private IAdminSystemMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());

		return "adminSystem";
	}
	
	
	@RequestMapping(value="/saveCategorie")
	public String saveCategorie(@Valid Categorie c, BindingResult bindingRes,
			Model model, MultipartFile file) throws IOException{
		
		if(bindingRes.hasErrors()){
			model.addAttribute("categories", metier.listCategories());
			return "adminSystem";
		}
		
		if(!file.isEmpty()){
			BufferedImage bi = ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
		}
		if(c.getIdCategorie()!=null){
				if(file.isEmpty()){
					Categorie catphoto = metier.getCategorie(c.getIdCategorie());
					c.setPhoto(catphoto.getPhoto());
				}
			
			metier.modifierCategorie(c);
		}else{
			metier.ajouterCategorie(c);
		}
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());

		return "adminSystem";
	}
	
	@RequestMapping(value="photoCat",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody //reponse envoyé directement dans le corps de la page
	public byte[] photoCat(Long idCat) throws IOException{
		Categorie c= metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}
	
	
	@RequestMapping(value="/suppCat")
	public String suppCat(Long idCat, Model model){
		metier.supprimerCategrorie(idCat);
		model.addAttribute("categorie", new Categorie()); //pour la saisie du categorie 
		model.addAttribute("categories", metier.listCategories()); // pour lister les categories

		return "adminSystem";
	}
	
	@RequestMapping(value="/editCat")
	public String edit(Long idCat, Model model){
		Categorie c = metier.getCategorie(idCat);

		model.addAttribute("categorie", c); //pour la saisie du categorie 
		//model.addAttribute("categories", metier.listCategories()); // pour lister les categories

		return "adminSystem";
	}
	
	
	
	//pour gerer les exception
		//dans la page jsp associé il faut faire des modifications 
		@Override
		public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
				Exception arg3) {
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("exception", arg3.getMessage());
			mv.setViewName("adminSystem");
			return mv;
		}
}
