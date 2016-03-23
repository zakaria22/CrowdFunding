package com.univ.angers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.univ.angers.entities.Categorie;
import com.univ.angers.entities.User;
import com.univ.angers.metier.AdminSystemMetierImpl;
import com.univ.angers.metier.InternauteMetier;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("internaute")
	private InternauteMetier metier;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		model.addAttribute("categories", metier.listCategories());
		return "home";
	}
	
	@RequestMapping(value="photoCat",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody //reponse envoyé directement dans le corps de la page
	public byte[] photoCat(Long idCat) throws IOException{
		Categorie c= metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}
	
	@RequestMapping(value="/register")
	public String index(Model model){
		model.addAttribute("user",new User());
		model.addAttribute("categories", metier.listCategories());
		return "registration";
	}
	
	@RequestMapping(value="/save")
	public ModelAndView save(@Valid User u, BindingResult bindingRes,
			Model model, MultipartFile file) throws IOException{
		
		if(bindingRes.hasErrors()){
			model.addAttribute("user",new User());
			return new ModelAndView("redirect:" + "/register");
		}
		
		if(!file.isEmpty()){
			BufferedImage bi = ImageIO.read(file.getInputStream());
			u.setPhoto(file.getBytes());
			u.setNomPhoto(file.getOriginalFilename());
		}
		
		
			metier.register(u);
		
		model.addAttribute("categories", metier.listCategories());
		return new ModelAndView("redirect:" + "/");

	}
	
}
