package com.univ.angers.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.univ.angers.metier.IContributeurMetier;
import com.univ.angers.metier.InternauteMetier;

@Controller
public class InternauteController {
	@Autowired
	@Qualifier("internauteMetier")
	private InternauteMetier metier;
}
