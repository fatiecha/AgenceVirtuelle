package test;

import org.gestion.av.metier.AgenceMetierImpl;
import org.gestion.av.metier.IAgenceMetier;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// pr faire l'injection des dependances
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		IAgenceMetier metier =  (IAgenceMetier)context.getBean("metier");
		
		
	}
}
