package test;

import org.gestion.av.entities.Contrat;
import org.gestion.av.metier.ConsulterReclamationsMetier;
import org.gestion.av.metier.DetailContratMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// pr faire l'injection des dependances
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		// ConsulterDevisMetier metier = (ConsulterDevisMetier)
		// context.getBean("consulterDevisMetier");
		ConsulterReclamationsMetier metier2 = (ConsulterReclamationsMetier) context
				.getBean("consulterReclamationsMetier");
		// ConsulterFacturesMetier metier = (ConsulterFacturesMetier)
		// context.getBean("consulterFacturesMetier");
		// ConsulterFacilitesMetier metier = (ConsulterFacilitesMetier)
		// context.getBean("consulterFacilitesMetier");
		
		
		
		
		DetailContratMetier metier = (DetailContratMetier) context.getBean("detailContratMetier");

		Contrat l = new Contrat();
		l = metier.detailContrat("1");
		
			
		System.out.println("agence "+l.getAgence());
		System.out.println("branchement "+l.getBranchement());
		System.out.println("date "+l.getDatePoseCompteurS());
			System.out.println("===============");

}
}