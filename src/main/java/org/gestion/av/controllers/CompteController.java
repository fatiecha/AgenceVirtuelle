package org.gestion.av.controllers;

import org.gestion.av.metier.ConsulterCompteMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompteController {
private ConsulterCompteMetier consulterCompteMetier;

public void setConsulterCompteMetier(ConsulterCompteMetier consulterCompteMetier) {
	this.consulterCompteMetier = consulterCompteMetier;
}
@RequestMapping(value = "/Compte/consultation")
public String index(Model model) {
	return "Compte/consultation";
}
}
