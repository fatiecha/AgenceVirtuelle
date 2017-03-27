package org.gestion.av.controllers;

import org.gestion.av.metier.ConsulterFacturesMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FactureController {
private ConsulterFacturesMetier consulterFacturesMetier;

public void setConsulterFacturesMetier(ConsulterFacturesMetier consulterFacturesMetier) {
	this.consulterFacturesMetier = consulterFacturesMetier;
}
@RequestMapping(value = "/Facture/listFactures")
public String index(Model model) {
	return "Facture/listFactures";
}

}
