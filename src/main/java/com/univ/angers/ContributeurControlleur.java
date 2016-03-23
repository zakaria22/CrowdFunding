package com.univ.angers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.univ.angers.metier.IContributeurMetier;

@Controller
public class ContributeurControlleur {

	@Autowired
	@Qualifier("contributeurMetier")
	private IContributeurMetier metier;
}
