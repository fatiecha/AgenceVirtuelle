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
import org.gestion.av.metier.AjoutClientMetier;
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
import com.couchbase.client.java.document.json.JsonObject;

public class Test {
	private JsonObject ObjectToJson(Consommation consommation) {

		JsonObject consommationJson = JsonObject.empty().put("periode", consommation.getPeriode()).put("volumeConsomme",
				consommation.getVolume_consomme());
		return consommationJson;
	}

	public static void main(String[] args) {
		// pr faire l'injection des dependances

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		ConsulterConsommationsMetier metierco = (ConsulterConsommationsMetier) context
				.getBean("consulterConsommationsMetier");

		List<Consommation> l = new ArrayList<>();
		l = metierco.consuterConsommations("3");
		for (int i = 0; i < l.size(); i++) {
			Consommation r = l.get(i);
			System.out.println("[");
			JsonObject consommationJson1 = JsonObject.empty().put("volumeConsomme",
					r.getVolume_consomme()).put("periode", r.getPeriode());
			System.out.println(consommationJson1 + ",");

		}
		System.out.println("]");
	}
}