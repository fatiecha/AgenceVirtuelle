package org.gestion.av.controllers;

import org.gestion.av.metier.IAgenceMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AgenceController {
	
	@Autowired
	public IAgenceMetier metier;

	@RequestMapping(value = "/")
	public String index(Model model) {
		
		return "index";
	}

	
	



	/*@RequestMapping(value = "/addClient")
	public String addClient(AgenceForm af, Model model) {
		try {
			metier.add(new Client(af.getNom(), af.getPrenom(), af.getCin(), af.getEmail(), af.getTel(), af.getMdp()));
		} catch (Exception e) {
			af.setException(e.getMessage());
		}
		model.addAttribute("agenceForm", af);
		return "Compte";
	}
*/
}
