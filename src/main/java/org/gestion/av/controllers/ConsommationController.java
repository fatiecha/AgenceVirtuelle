package org.gestion.av.controllers;

import org.gestion.av.metier.ConsulterConsommationsMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsommationController {
private ConsulterConsommationsMetier consulterConsommationsMetier;
	
	public void setConsulterConsommationsMetier(ConsulterConsommationsMetier consulterConsommationsMetier) {
		this.consulterConsommationsMetier = consulterConsommationsMetier;
	}

	@RequestMapping(value = "/Consommation/listConsommations")
	public String index(Model model) {
		return "Consommation/listConsommations";
	}
}
