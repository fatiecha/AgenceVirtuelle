package test;

import org.gestion.av.metier.AjoutClientMetier;
import org.gestion.av.metier.AjoutConCliMetier;
import org.gestion.av.metier.AjoutDemAboMetier;
import org.gestion.av.metier.AjoutReclamationMetier;
import org.gestion.av.metier.ConnexionMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// pr faire l'injection des dependances
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		
		AjoutDemAboMetier metier3=(AjoutDemAboMetier)context.getBean("metier3");
		AjoutConCliMetier metier2=(AjoutConCliMetier)context.getBean("metier2");
			//int b=metier.seConnecter("az","az");
			//System.out.println(b);
		String  a=metier2.ajouterConCli("15","12");
		System.out.println(a);

		
	}
}
