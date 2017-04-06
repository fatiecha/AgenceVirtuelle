package org.gestion.av.controllers;

import org.gestion.av.entities.Client;
import org.gestion.av.metier.AjoutClientMetier;
import org.gestion.av.metier.ConnexionMetier;
import org.gestion.av.metier.CountFIMetier;
import org.gestion.av.service.IAgenceService;
import org.gestion.av.serviceImpl.AgenceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {
	@Autowired
	private CountFIMetier countFIMetier;
	private AjoutClientMetier clientMetier;
	private ConnexionMetier connexionMetier;
	private IAgenceService agenceService;

	public void setConnexionMetier(ConnexionMetier connexionMetier) {
		this.connexionMetier = connexionMetier;
	}

	public void setCountFIMetier(CountFIMetier countFIMetier) {
		this.countFIMetier = countFIMetier;
	}

	public void setClientMetier(AjoutClientMetier clientMetier) {
		this.clientMetier = clientMetier;
	}

	public void setAgenceService(IAgenceService agenceService) {
		this.agenceService = agenceService;
	}

	@RequestMapping(value = "/inscriptionClient", method = RequestMethod.GET)
	public String ajoutClient(Model model) {
		model.addAttribute("client", new Client());
		return "inscriptionClient";
	}

	@RequestMapping(value = "/sinscrire", method = RequestMethod.POST)
	public String Save(@ModelAttribute(value = "client") Client c, Model model) {
		clientMetier.ajoutClient(c.getNom(), c.getPrenom(), c.getCIN(), c.getEmail(), c.getTel(), c.getMDP());
		return "redirect:/Contrat/association";
	}

	@RequestMapping(value = "/seConnecter")
	public String login(@ModelAttribute(value = "client") Client cli, Model model) {
		int a;
		a = connexionMetier.seConnecter(cli.getEmail(), cli.getMDP());
		if (a != 0) {
			// agenceService.getClient(a);
			return "redirect:/Contrat/association";
		}
		return "connexionClient";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String seConnecter(Model model) {
		 model.addAttribute("client",new Client());
		//model.addAttribute("client", agenceService.getClient(1));
		model.addAttribute("countModel", countFIMetier.countFactureImpayees("1"));
		return "connexionClient";
	}

	@RequestMapping(value = "/updateClient")
	public String index2(Model model) {
		return "updateClient";
	}
}
