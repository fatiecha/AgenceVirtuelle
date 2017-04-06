package org.gestion.av.controllers;

import org.gestion.av.metier.AjoutDemAboMetier;
import org.gestion.av.models.AboModel;
import org.gestion.av.models.ConCliModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping(value = "/Abonnement")
@Controller
public class AboController {
	
	@Autowired
	private AjoutDemAboMetier aboMetier;
	
	
	public void setAboMetier(AjoutDemAboMetier pAboMetier) {
		this.aboMetier = pAboMetier;
	}

//	@RequestMapping(value = "/")
//	public String index(Model model) {
//		return "Abonnement/ajoutAbo";
//	}
	@RequestMapping(value = "/ajoutAbo", method = RequestMethod.GET)
	public String ajoutContratClient(Model model) {
		model.addAttribute("abonnement", new AboModel());
		return "Abonnement/ajoutAbo";
	}

	@RequestMapping(value = "/creerAbonnement", method = RequestMethod.POST)
	public String SaveAbo(@ModelAttribute(value = "abonnement") AboModel a, Model model) {
		String msg = null;
		msg = aboMetier.ajouterAbo(a.getTournee(), "1", a.getService(), a.getTarif());
		if (msg.equals("oui")) {
			return "redirect:/Reclamation/listReclamations";
		}
		return "Abonnement/ajoutAbo";
	}}
