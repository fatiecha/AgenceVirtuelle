package org.gestion.av.controllers;

import org.gestion.av.metier.ConsulterFacilitesMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FaciliteController {
private ConsulterFacilitesMetier consulterFacilitesMetier;
	
	public void setConsulterFacilitesMetier(ConsulterFacilitesMetier consulterFacilitesMetier) {
		this.consulterFacilitesMetier = consulterFacilitesMetier;
	}

	@RequestMapping(value = "/Facilites/listFacilites")
	public String index(Model model) {
		return "Facilites/listFacilites";
	}
}
