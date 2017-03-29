package test;

import java.util.ArrayList;
import java.util.List;

import org.gestion.av.entities.Compte;
import org.gestion.av.entities.Consommation;
import org.gestion.av.entities.Devis;
import org.gestion.av.entities.Reclamation;
import org.gestion.av.metier.ConsulterCompteMetier;
import org.gestion.av.metier.ConsulterConsommationsMetier;
import org.gestion.av.metier.ConsulterDevisMetier;
import org.gestion.av.metier.ConsulterReclamationsMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// pr faire l'injection des dependances
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		ConsulterDevisMetier metier = (ConsulterDevisMetier) context.getBean("consulterDevisMetier");
		ConsulterReclamationsMetier metier2 = (ConsulterReclamationsMetier) context
				.getBean("consulterReclamationsMetier");

		List<Devis> l = new ArrayList<Devis>();

		l = metier.consuterDevis("1");
		for (int i = 0; i < l.size(); i++) {
			Devis c = new Devis();
			c = l.get(i);
System.out.println(c.getId());
System.out.println(c.getDateS());
System.out.println(c.getMontant());
System.out.println(c.isEtat());
System.out.println("===============");
		}

	}
}