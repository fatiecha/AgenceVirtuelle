package org.gestion.av.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.gestion.av.entities.Client;
import org.gestion.av.metier.AjoutClientMetier;
import org.gestion.av.metier.ConnexionMetier;
import org.gestion.av.metier.CountFIMetier;
import org.gestion.av.service.IAgenceService;
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
		return "redirect:/Contrat/listContrats";
	}

	@RequestMapping(value = "/seConnecter")
	public String login(HttpServletRequest pRequest, Model model,@ModelAttribute(value = "client") Client cli) {
		
		HttpSession pSession = pRequest.getSession();
		int idClientConnecte;
		
		idClientConnecte = connexionMetier.seConnecter(cli.getEmail(), cli.getMDP());
		if (idClientConnecte != 0) {
			pSession.setAttribute("nbrFacture",countFIMetier.countFactureImpayees(Long.toString(idClientConnecte)));
			pSession.setAttribute("clientConnecte", agenceService.getClient(idClientConnecte));
			return "redirect:/Contrat/listContrats";
		}
		
		return "connexionClient";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String seConnecter(Model model) {
		 model.addAttribute("client",new Client());
		return "connexionClient";
	}

	@RequestMapping(value = "/updateClient", method = RequestMethod.GET)
	public String updateClient(HttpServletRequest pRequest,Model model) {
		model.addAttribute("client", (Client) pRequest.getSession().getAttribute("clientConnecte"));
		return "updateClient";
	}
	@RequestMapping(value = "/majClient", method = RequestMethod.POST)
	public String majClient(@ModelAttribute(value = "client") Client client, Model model) {
		agenceService.updateClient(new Client(client.getId(),client.getNom(),client.getPrenom(),client.getCIN(),client.getEmail(),client.getTel(),client.getMDP()));
		return "redirect:/Contrat/association";
	}
	
	
}
