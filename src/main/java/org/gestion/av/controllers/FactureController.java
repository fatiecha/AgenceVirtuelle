package org.gestion.av.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gestion.av.entities.Client;
import org.gestion.av.entities.Facture;
import org.gestion.av.metier.ConsulterContratsMetier;
import org.gestion.av.metier.ConsulterFacturesMetier;
import org.gestion.av.serviceImpl.GeneratePDF;
import org.gestion.av.serviceImpl.MailMail;
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
	private GeneratePDF generatePDF;
	private MailMail mailMail;
	
	public void setMailMail(MailMail mailMail) {
		this.mailMail = mailMail;
	}

	public void setConsulterContratsMetier(ConsulterContratsMetier consulterContratsMetier) {
		this.consulterContratsMetier = consulterContratsMetier;
	}

	public void setGeneratePDF(GeneratePDF generatePDF) {
		this.generatePDF = generatePDF;
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
		model.addAttribute("emptyFacture", factures.isEmpty());
		model.addAttribute("contrats", consulterContratsMetier.consulterContrats(Long.toString(client.getId())));
		return "Facture/listFactures";
	}

	@RequestMapping(value = "/genererPDF", method = RequestMethod.POST)
	public String genererPDF(HttpServletRequest pRequest, @ModelAttribute(value = "facture") Facture facture,
			Model model,long idFacture) {
		Client client = (Client) pRequest.getSession().getAttribute("clientConnecte");
		generatePDF.genererPdf(idFacture,client.getId());
		mailMail.sendMail(client.getEmail(), idFacture);
		return "Facture/listFactures";
	}
}
