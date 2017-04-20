package org.gestion.av.controllers;

import static org.mockito.Matchers.matches;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.gestion.av.entities.Client;
import org.gestion.av.entities.Facture;
import org.gestion.av.entities.Reclamation;
import org.gestion.av.metier.ConsulterContratsMetier;
import org.gestion.av.metier.ConsulterFacturesMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/Facture")
@Controller
public class FactureController {
	private ConsulterFacturesMetier consulterFacturesMetier;
	private ConsulterContratsMetier consulterContratsMetier;

	public void setConsulterContratsMetier(ConsulterContratsMetier consulterContratsMetier) {
		this.consulterContratsMetier = consulterContratsMetier;
	}

	public void setConsulterFacturesMetier(ConsulterFacturesMetier consulterFacturesMetier) {
		this.consulterFacturesMetier = consulterFacturesMetier;
	}
	@RequestMapping(value = "/simulerFacture", method = RequestMethod.GET)
	public String simulerFacture(HttpServletRequest pRequest, Model model) {
		Client c = (Client) pRequest.getSession().getAttribute("clientConnecte");
		model.addAttribute("contrats", consulterContratsMetier.consulterContrats(Long.toString(c.getId())));
		model.addAttribute("facture", new Facture());
		return "Facture/simulerFacture";
	}
	@RequestMapping(value = "/simulation", method = RequestMethod.POST)
	public String simulation(HttpServletRequest pRequest, @ModelAttribute(value = "facture") Facture facture,
			Model model) {
		Client client = (Client) pRequest.getSession().getAttribute("clientConnecte");
		List<Facture> factures = new ArrayList<>();
		factures = consulterFacturesMetier.consuterFacture(Long.toString(facture.getContrat().getId()));
		model.addAttribute("factures", factures);
		model.addAttribute("contrats", consulterContratsMetier.consulterContrats(Long.toString(client.getId())));
		return "Facture/simulerFacture";
	}
	@RequestMapping(value = "/listFactures", method = RequestMethod.GET)
	public String listFactures(HttpServletRequest pRequest, Model model) {
		Client c = (Client) pRequest.getSession().getAttribute("clientConnecte");
		model.addAttribute("contrats", consulterContratsMetier.consulterContrats(Long.toString(c.getId())));
		model.addAttribute("facture", new Facture());
		return "Facture/listFactures";
	}

	@RequestMapping(value = "/FiltreListes", method = RequestMethod.POST)
	public String filtreListFacture(HttpServletRequest pRequest, @ModelAttribute(value = "facture") Facture facture,
			Model model) {
		Client client = (Client) pRequest.getSession().getAttribute("clientConnecte");
		List<Facture> factures = new ArrayList<>();
		factures = consulterFacturesMetier.consuterFacture(Long.toString(facture.getContrat().getId()));
		model.addAttribute("factures", factures);
		model.addAttribute("emptyFacture",factures.isEmpty());
		model.addAttribute("contrats", consulterContratsMetier.consulterContrats(Long.toString(client.getId())));
		return "Facture/listFactures";
	}

}
