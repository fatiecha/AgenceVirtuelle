package org.gestion.av.controllers;

import org.gestion.av.metier.AjoutClientMetier;
import org.gestion.av.metier.AjoutDemAboMetier;
import org.gestion.av.metier.ConnexionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {
	@Autowired
	private AjoutClientMetier clientMetier;
	private ConnexionMetier connexionMetier;
	


	public void setConnexionMetier(ConnexionMetier connexionMetier) {
		this.connexionMetier = connexionMetier;
	}




	public void setClientMetier(AjoutClientMetier clientMetier) {
		this.clientMetier = clientMetier;
	}

	@RequestMapping(value = "/ajoutClient")
	public String index(Model model) {
		return "ajoutClient";
	}
	@RequestMapping(value = "/connexion")
	public String index2(Model model) {
		return "connexion";
	}
}
