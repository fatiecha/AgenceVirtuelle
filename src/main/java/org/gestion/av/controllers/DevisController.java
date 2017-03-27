package org.gestion.av.controllers;

import org.gestion.av.metier.ConsulterDevisMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DevisController {
	private ConsulterDevisMetier consulterDevisMetier;
	
	public void setConsulterDevisMetier(ConsulterDevisMetier consulterDevisMetier) {
		this.consulterDevisMetier = consulterDevisMetier;
	}

	@RequestMapping(value = "/Devis/listDevis")
	public String index(Model model) {
		return "Devis/listDevis";
	}
}
