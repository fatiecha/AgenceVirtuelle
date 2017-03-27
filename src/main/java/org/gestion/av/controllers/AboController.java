package org.gestion.av.controllers;

import org.gestion.av.metier.AjoutDemAboMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboController {
	
	@Autowired
	private AjoutDemAboMetier aboMetier;
	
	
	public void setAboMetier(AjoutDemAboMetier pAboMetier) {
		this.aboMetier = pAboMetier;
	}

	@RequestMapping(value = "/")
	public String index(Model model) {
		return "Abonnement/ajoutAbo";
	}
	@RequestMapping(value = "/Abonnement/ajoutAbo")
	public String index2(Model model) {
		return "Abonnement/ajoutAbo";
	}
}
