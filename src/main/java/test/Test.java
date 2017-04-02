package test;

import java.util.ArrayList;
import java.util.List;

import org.gestion.av.entities.Compte;
import org.gestion.av.entities.Consommation;
import org.gestion.av.entities.Contrat;
import org.gestion.av.entities.Devis;
import org.gestion.av.entities.Echeance;
import org.gestion.av.entities.Facilite;
import org.gestion.av.entities.Facture;
import org.gestion.av.entities.Reclamation;
import org.gestion.av.metier.ConnexionMetier;
import org.gestion.av.metier.ConsulterCompteMetier;
import org.gestion.av.metier.ConsulterConsommationsMetier;
import org.gestion.av.metier.ConsulterContratsMetier;
import org.gestion.av.metier.ConsulterDevisMetier;
import org.gestion.av.metier.ConsulterEcheancesMetier;
import org.gestion.av.metier.ConsulterFacilitesMetier;
import org.gestion.av.metier.ConsulterFacturesMetier;
import org.gestion.av.metier.ConsulterReclamationsMetier;
import org.gestion.av.metier.DetailContratMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) {
		// pr faire l'injection des dependances
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		 ConsulterDevisMetier metierd = (ConsulterDevisMetier)
		 context.getBean("consulterDevisMetier");

		 ConsulterFacturesMetier metierf = (ConsulterFacturesMetier)
		 context.getBean("consulterFacturesMetier");
		
		 ConsulterFacilitesMetier metierfa = (ConsulterFacilitesMetier)
		 context.getBean("consulterFacilitesMetier");
		
		 ConsulterContratsMetier metierc = (ConsulterContratsMetier)
				 context.getBean("consulterContratsMetier");
		 ConsulterReclamationsMetier metierr = (ConsulterReclamationsMetier)
				 context.getBean("consulterReclamationsMetier");
		 ConsulterCompteMetier metiercp = (ConsulterCompteMetier)
				 context.getBean("consulterCompteMetier");
		 ConsulterEcheancesMetier metiere = (ConsulterEcheancesMetier)
				 context.getBean("consulterEcheancesMetier");
		 ConsulterConsommationsMetier metierco = (ConsulterConsommationsMetier)
		 context.getBean("consulterConsommationsMetier");
		 
//		 ConnexionMetier aj = (ConnexionMetier)
//				 context.getBean("connexionMetier");
//long s=aj.seConnecter("az", "az");
//System.out.println(s);
		List<Contrat> l = new ArrayList<Contrat>();
		l= metierc.consulterContrats("1");
		for(int i=0;i<l.size();i++){
			Contrat t=l.get(i);
			System.out.println(t.getBranchement());
			System.out.println("datec "+t.getDatePoseCompteurS());
			System.out.println("nom "+t.getNomClient());

System.out.println("hhhhhhhh");
		}
		
		
		
		
		
		
		
		
//		System.out.println("agence "+l.getAgence());
//		System.out.println("branchement "+l.getBranchement());
//		System.out.println("date "+l.getDatePoseCompteurS());
//			System.out.println("===============");
//		public static void main(String[] args) {
//			DetailContratWS c=new DetailContratWS();
//			Contrat t=new Contrat();
//			t=c.detailContrat("2");
//			System.out.println(t.getDatePoseCompteur());
//			System.out.println(t.getAgence());
//			System.out.println(t.getBranchement());
//			System.out.println(t.getEtat());
//			System.out.println(t.getTournee());
//			System.out.println(t.getTarif());
//
//		}
}
}