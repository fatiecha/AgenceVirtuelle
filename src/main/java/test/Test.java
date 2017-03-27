package test;

import java.util.ArrayList;
import java.util.List;

import org.gestion.av.entities.Reclamation;
import org.gestion.av.metier.ConsulterReclamationsMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// pr faire l'injection des dependances
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		ConsulterReclamationsMetier metier = (ConsulterReclamationsMetier) context.getBean("metier");
		List<Reclamation> l = new ArrayList<Reclamation>();

		l = metier.consuterReclamations("1");
		for (int i = 0; i < l.size(); i++) {
			Reclamation d = l.get(i);

			System.out.println("com" + d.getCommentaire());
			System.out.println("org" + d.getOrigine());

			System.out.println("typer" + d.getTypeR());
			System.out.println("idcon" + d.getIdcon());

			System.out.println("etat" + d.getEtat());
		

		}

	}

}