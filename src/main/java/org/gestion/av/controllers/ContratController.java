package org.gestion.av.controllers;

import org.gestion.av.metier.AjoutConCliMetier;
import org.gestion.av.metier.ConsulterContratsMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContratController {
private ConsulterContratsMetier consulterContratsMetier;
private AjoutConCliMetier concliMetier ;
	public void setConcliMetier(AjoutConCliMetier concliMetier) {
	this.concliMetier = concliMetier;
}

	public void setConsulterContratsMetier(ConsulterContratsMetier consulterContratsMetier) {
		this.consulterContratsMetier = consulterContratsMetier;
	}

	@RequestMapping(value = "/Contrat/listContrats")
	public String index(Model model) {
		return "Contrat/listContrats";
	}
	@RequestMapping(value = "/Contrat/association")
	public String index2(Model model) {
		return "Contrat/association";
	}
}
