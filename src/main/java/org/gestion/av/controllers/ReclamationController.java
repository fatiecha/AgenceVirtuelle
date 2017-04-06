package org.gestion.av.controllers;

import org.gestion.av.entities.Reclamation;
import org.gestion.av.metier.AjoutReclamationMetier;
import org.gestion.av.metier.ConsulterContratsMetier;
import org.gestion.av.metier.ConsulterReclamationsMetier;
import org.gestion.av.service.IAgenceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping(value = "/Reclamation")
@Controller
public class ReclamationController {
	
	private ConsulterContratsMetier consulterContratsMetier;
	private AjoutReclamationMetier reclamationMetier;
	private ConsulterReclamationsMetier consulterReclamationsMetier;
	private IAgenceService agenceService;

	public void setReclamationMetier(AjoutReclamationMetier reclamationMetier) {
		this.reclamationMetier = reclamationMetier;
	}

	public void setConsulterReclamationsMetier(ConsulterReclamationsMetier consulterReclamationsMetier) {
		this.consulterReclamationsMetier = consulterReclamationsMetier;
	}
	
	public void setConsulterContratsMetier(ConsulterContratsMetier consulterContratsMetier) {
		this.consulterContratsMetier = consulterContratsMetier;
	}

	public void setAgenceService(IAgenceService agenceService) {
		this.agenceService = agenceService;
	}

	@RequestMapping(value = "/listReclamations")
	public String listReclamation(Model model) {
		return "Reclamation/listReclamations";
	}

	@RequestMapping(value = "/ajoutReclamation", method = RequestMethod.GET)
	public String ajoutReclamation(Model model) {
		model.addAttribute("contrats", consulterContratsMetier.consulterContrats("1"));
		model.addAttribute("typesReclamation", agenceService.getlibelleTypeReclamation());
		model.addAttribute("reclamation",new Reclamation());
		return "Reclamation/ajoutReclamation";
	}

	
@RequestMapping(value = "/creerReclamation",method=RequestMethod.POST)
public String SaveReclamation(@ModelAttribute(value = "reclamation") Reclamation r, Model model ) {
	String msg =null;
	//msg=reclamationMetier.ajouterReclamation(Long.toString(r.getIdcon()), r.getOrigine(), r.getTypeR(), r.getCommentaire());
	msg=reclamationMetier.ajouterReclamation(Long.toString(r.getIdcon()),r.getOrigine(), r.getTypeR(), r.getCommentaire());
if(msg.equals("oui")){
		return "redirect:/Reclamation/listReclamations";
	}
	return "Reclamation/ajoutReclamation";
}

}
