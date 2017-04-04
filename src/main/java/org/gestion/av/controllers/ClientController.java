package org.gestion.av.controllers;

import org.gestion.av.entities.Client;
import org.gestion.av.metier.AjoutClientMetier;
import org.gestion.av.metier.ConnexionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/inscriptionClient",method=RequestMethod.GET)
	public String ajoutClient(Model model) {
		model.addAttribute(new Client());
		return "inscriptionClient";
	}
	
	
	@RequestMapping(value = "/sinscrire",method=RequestMethod.POST)
	public String Save(@ModelAttribute(value = "client") Client c, Model model ) {
		clientMetier.ajoutClient(c.getNom(),c.getPrenom(),c.getCIN(),c.getEmail(),c.getTel(),c.getMDP());
		return "redirect:/Contrat/association";
	}
	
	
	@RequestMapping(value = "/seConnecter")
	public String login(@ModelAttribute(value = "client") Client cli, Model model ) {
		int a;
		a=connexionMetier.seConnecter(cli.getEmail(), cli.getMDP());
		if(a!=0){
			return "redirect:/Contrat/association";
		}
		return "connexionClient";
	}
	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String seConnecter(Model model) {
		model.addAttribute(new Client());
		return "connexionClient";
	}
}
