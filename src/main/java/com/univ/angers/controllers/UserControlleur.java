package com.univ.angers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.univ.angers.metier.IContributeurMetier;

@Controller
@RequestMapping(value="/profile")
public class UserControlleur {

	@Autowired
	@Qualifier("contributeurMetier")
	private IContributeurMetier metier;
	
	@RequestMapping(value = "/")
	public String home(Long idUSer, Model model) {
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("user", metier.getUser(idUSer));
		model.addAttribute("listPro", metier.listUserProjets(idUSer));
		model.addAttribute("listcont", metier.listUserContribution(idUSer));
		model.addAttribute("uprojets", metier.listUserProjets(idUSer).size());
		model.addAttribute("ucontrib", metier.listUserContribution(idUSer).size());
		
		return "profile";
	}
}
