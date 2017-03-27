package org.gestion.av.controllers;

import org.gestion.av.metier.AjoutReclamationMetier;
import org.gestion.av.metier.ConsulterReclamationsMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReclamationController {
private AjoutReclamationMetier reclamationMetier;
private ConsulterReclamationsMetier consulterReclamationsMetier;


public void setReclamationMetier(AjoutReclamationMetier reclamationMetier) {
	this.reclamationMetier = reclamationMetier;
}

public void setConsulterReclamationsMetier(ConsulterReclamationsMetier consulterReclamationsMetier) {
	this.consulterReclamationsMetier = consulterReclamationsMetier;
}

@RequestMapping(value = "/Reclamation/ajoutReclamation")
public String index(Model model) {
	return "Reclamation/ajoutReclamation";
}
@RequestMapping(value = "/Reclamation/listReclamations")
public String index2(Model model) {
	return "Reclamation/listReclamations";
}
}
