package com.univ.angers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.univ.angers.metier.IContributeurMetier;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	@Qualifier("contributeurMetier")
	private IContributeurMetier metier;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Long idUSer, Model model) {
		model.addAttribute("user", metier.getUser(idUSer));
		return "profile";
	}
}
