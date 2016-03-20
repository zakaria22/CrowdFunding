package com.univ.angers.controlleur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.univ.angers.HomeController;
import com.univ.angers.entities.Categorie;
import com.univ.angers.metier.IAdminProjetMetier;
import com.univ.angers.metier.IAdminSystemMetier;

@Controller
@RequestMapping(value="/adminProjet")
public class AdminProjetController {
	

	@Autowired
	@Qualifier("adminProjetMetier")
	private IAdminProjetMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		return "adminProjet";
	}

}
