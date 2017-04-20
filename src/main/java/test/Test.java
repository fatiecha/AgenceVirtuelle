package test;

import java.util.ArrayList;
import java.util.List;

import org.gestion.av.daoImpl.AgenceDaoImpl;
import org.gestion.av.entities.Client;
import org.gestion.av.entities.Compte;
import org.gestion.av.entities.Consommation;
import org.gestion.av.entities.Contrat;
import org.gestion.av.entities.Devis;
import org.gestion.av.entities.Echeance;
import org.gestion.av.entities.Facilite;
import org.gestion.av.entities.Facture;
import org.gestion.av.entities.Reclamation;
import org.gestion.av.entities.Type_reclamation;
import org.gestion.av.metier.AjoutConCliMetier;
import org.gestion.av.metier.AjoutDemAboMetier;
import org.gestion.av.metier.ConnexionMetier;
import org.gestion.av.metier.ConsulterCompteMetier;
import org.gestion.av.metier.ConsulterConsommationsMetier;
import org.gestion.av.metier.ConsulterContratsMetier;
import org.gestion.av.metier.ConsulterDevisMetier;
import org.gestion.av.metier.ConsulterEcheancesMetier;
import org.gestion.av.metier.ConsulterFacilitesMetier;
import org.gestion.av.metier.ConsulterFacturesMetier;
import org.gestion.av.metier.ConsulterReclamationsMetier;
import org.gestion.av.metier.CountFIMetier;
import org.gestion.av.service.IAgenceService;
import org.gestion.av.serviceImpl.AgenceServiceImpl;
import org.hibernate.engine.profile.Association;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// pr faire l'injection des dependances

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		IAgenceService metier = (IAgenceService) context.getBean("agenceServiceImpl");
//		 metier.updateClient(new Client());
	   metier.updateClient(new Client(7,"ech","ech","ech","ech","ech","ech"));
//		CountFIMetier metierd = (CountFIMetier) context.getBean("countFIMetier");
		
		
		
		
//		metier.getlibelleTypeReclamation();
		//
		// ConsulterFacturesMetier metierf = (ConsulterFacturesMetier)
		// context.getBean("consulterFacturesMetier");
		//
//		 ConsulterFacilitesMetier metierfa = (ConsulterFacilitesMetier)
//		 context.getBean("consulterFacilitesMetier");
		//
//		 ConsulterContratsMetier metierc = (ConsulterContratsMetier)
//		 context.getBean("consulterContratsMetier");
//		 ConsulterReclamationsMetier metierr = (ConsulterReclamationsMetier)
//		 context.getBean("consulterReclamationsMetier");
//		 ConsulterCompteMetier metiercp = (ConsulterCompteMetier)
//		 context.getBean("consulterCompteMetier");
//		 Compte c=new Compte();
//		 c=metiercp.consuterCompte("10");
//		 System.out.println(c.getMt_exigible());
//		 System.out.println(c.getCredit());
//		 System.out.println(c.getMt_impay�());
//		 System.out.println(c.getProvision());
//		 System.out.println(c.getIdContrat());

		// ConsulterEcheancesMetier metiere = (ConsulterEcheancesMetier)
		// context.getBean("consulterEcheancesMetier");
		// ConsulterConsommationsMetier metierco =
		// (ConsulterConsommationsMetier)
		// context.getBean("consulterConsommationsMetier");
		// ConnexionMetier aj = (ConnexionMetier)
		// context.getBean("connexionMetier");
		// long s=aj.seConnecter("az", "az");
		// System.out.println(s);
//		 List<Contrat> l = new ArrayList<Contrat>();
//		 l= metierc.consulterContrats("1");
//		 for(int i=0;i<l.size();i++){
//		 Contrat t=l.get(i);
//		 System.out.println(t.getNumero());
//		
//		 }

//		System.out.println("hhhhhhh");
//		 List<Facilite> l=new ArrayList<>();
//		 l=metierfa.consuterFacilite("1");
//		 for(int i=0;i<l.size();i++){
//			 Facilite r=l.get(i);
//		 System.out.println(r.getEtat());
//		Client c = metier.getClient(1l);
//		System.out.println(c.getNom());
//	}
//		AjoutDemAboMetier metieroo = (AjoutDemAboMetier) context.getBean("aboMetier");
//System.out.println(metieroo.ajouterAbo("4455556", "1", "eau", "tarif"));
	// System.out.println("agence "+l.getAgence());
	// System.out.println("branchement "+l.getBranchement());
	// System.out.println("date "+l.getDatePoseCompteurS());
	// System.out.println("===============");
	// public static void main(String[] args) {
	// DetailContratWS c=new DetailContratWS();
	// Contrat t=new Contrat();
	// t=c.detailContrat("2");
	// System.out.println(t.getDatePoseCompteur());
	// System.out.println(t.getAgence());
	// System.out.println(t.getBranchement());
	// System.out.println(t.getEtat());
	// System.out.println(t.getTournee());
	// System.out.println(t.getTarif());
	//
	// }
	}
}