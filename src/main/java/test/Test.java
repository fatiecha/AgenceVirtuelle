package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import org.gestion.av.entities.Client;
import org.gestion.av.entities.Consommation;
import org.gestion.av.entities.Contrat;
import org.gestion.av.entities.Demande_abonnement;
import org.gestion.av.entities.Facture;
import org.gestion.av.service.IAgenceService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Test {
	// pr faire l'injection des dependances
	static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "applicationContext.xml" });
	static IAgenceService agenceService = (IAgenceService) context.getBean("agenceServiceImpl");

	public static void genererPdf(long idFacture, long idContrat, long idClient) {
		Client client = agenceService.getClient(idClient);
		Facture facture = agenceService.getFactureById(idFacture);
		Contrat contrat = agenceService.getContratById(idContrat);
		Demande_abonnement demande_abonnement = agenceService.getAbonnementByIdContrat(idContrat);
		Consommation consommation = agenceService.getConsommationByIdFactureIdContrat(idFacture, idContrat);
		String chemin = "C:\\Users\\Fatimzhra\\Desktop\\Files\\Facture" + idFacture + ".pdf";
		Document document = new Document();
		try {
			Font font = new Font();
			font.setSize(14f);
			PdfWriter.getInstance(document, new FileOutputStream(chemin));
			document.open();
			Paragraph titre = new Paragraph("Facture d'" + contrat.getService() + " N°" + facture.getId());
			titre.setAlignment(Element.ALIGN_CENTER);
			document.add(titre);
			document.add(new Paragraph("            "));
			Paragraph NomPrenom = new Paragraph("Nom Prénom Client : " + client.getNom() + "  " + client.getPrenom());
			document.add(NomPrenom);
			Paragraph Tel = new Paragraph("N° Téléphone : " + client.getTel());
			document.add(Tel);
			Paragraph periodeFacturation = new Paragraph("Période Facturation : " + facture.getPeriode());
			document.add(periodeFacturation);
			document.add(new Paragraph("            "));
			// table.setWidthPercentage(100);
			Paragraph InfoContrat = new Paragraph("Informations Contrat :");
			document.add(InfoContrat);
			document.add(new Paragraph("            "));
			document.add(Tableau1(demande_abonnement, contrat, idClient));
			document.add(new Paragraph("            "));
			document.add(new Paragraph("            "));
			Paragraph InfoConsommation = new Paragraph("Informations Consommation :");
			document.add(InfoConsommation);
			document.add(new Paragraph("            "));
			document.add(Tableau2(consommation));
			document.add(new Paragraph("            "));
			document.add(new Paragraph("            "));
			Paragraph detailFacture = new Paragraph("Détails facture :");
			document.add(detailFacture);
			document.add(new Paragraph("            "));
			document.add(Tableau3(consommation, contrat));
			document.add(new Paragraph("            "));
			document.add(new Paragraph("            "));
			document.add(new Paragraph("            "));
			document.add(new Paragraph("            "));

			document.add(Tableau5(facture));
			document.add(new Paragraph("            "));
			document.add(new Paragraph("            "));

			document.add(Tableau4());
		} catch (DocumentException de) {

		} catch (IOException de) {

		}

		document.close();
	}

	public static Paragraph Tableau4() {

		Paragraph footer = new Paragraph("Numéro de centre relation client: 080 2000 123 ");
		footer.setAlignment(Element.ALIGN_CENTER);
		return footer;
	}

	public static Paragraph Tableau5(Facture facture) {
		Font f = new Font();
		// FontFamily.ROMAN,50.0f,Font.UNDERLINE,BaseColor.RED
		f.setColor(BaseColor.LIGHT_GRAY);
		f.setFamily("Helvetica");
		f.setSize(20.0f);
		Paragraph titre = new Paragraph("Facture à payer avant :  " + facture.getDate_exigibilite(), f);
		titre.setAlignment(Element.ALIGN_CENTER);
		return titre;
	}

	public static PdfPTable Tableau3(Consommation consommation, Contrat contrat) {
		double prixHT;
		if (contrat.getService().equals("Eau") || contrat.getService().equals("eau")) {
			prixHT = 1.7;
		} else {
			prixHT = 0.7904;
		}
		PdfPTable table = new PdfPTable(6);
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Détail de votre facture "));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Consommation "));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Prix unitaire HT "));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Montant HT "));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Taux TVA "));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Montant TVA "));
		table.addCell(cell);
		table.addCell(new PdfPCell(new Paragraph("Redevances de consommation" + contrat.getService())));
		table.addCell(new PdfPCell(new Paragraph("" + consommation.getVolume_facture())));
		table.addCell(new PdfPCell(new Paragraph("" + prixHT)));
		double montantHT = consommation.getVolume_facture() * prixHT;
		double montantTVA = consommation.getVolume_facture() * prixHT * 14 / 100;
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2); // arrondi à 2 chiffres apres la
										// virgules
		df.setMinimumFractionDigits(2);
		df.setDecimalSeparatorAlwaysShown(true);
		table.addCell(new PdfPCell(new Paragraph("" + Double.parseDouble(df.format(montantHT)))));
		table.addCell(new PdfPCell(new Paragraph("14.0")));
		table.addCell(new PdfPCell(new Paragraph("" + Double.parseDouble(df.format(montantTVA)))));
		table.addCell(new PdfPCell(new Paragraph("Redevances fixes " + contrat.getService())));
		table.addCell(new PdfPCell(new Paragraph("1.00")));
		table.addCell(new PdfPCell(new Paragraph("9.87")));
		table.addCell(new PdfPCell(new Paragraph("9.87")));
		table.addCell(new PdfPCell(new Paragraph("")));
		table.addCell(new PdfPCell(new Paragraph("1.75")));
		table.addCell(new PdfPCell(new Paragraph("Timbre ")));
		table.addCell(new PdfPCell(new Paragraph("")));
		table.addCell(new PdfPCell(new Paragraph("")));
		table.addCell(new PdfPCell(new Paragraph("0.16")));
		table.addCell(new PdfPCell(new Paragraph("")));
		table.addCell(new PdfPCell(new Paragraph("")));
		cell = new PdfPCell(new Phrase("Total Hors Taxes"));
		cell.setColspan(4);
		table.addCell(cell);
		double totalHT = montantHT + 9.87 + 0.16;
		cell = new PdfPCell(new Phrase("" + Double.parseDouble(df.format(totalHT))));
		cell.setColspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Total TVA"));
		cell.setColspan(4);
		table.addCell(cell);
		double totalTVA = montantTVA + 1.75;
		cell = new PdfPCell(new Phrase(new Paragraph("" + Double.parseDouble(df.format(totalTVA)))));
		cell.setColspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Montant TTC"));
		cell.setColspan(4);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(new Paragraph("" + Double.parseDouble(df.format(totalTVA + totalHT)))));
		cell.setColspan(2);
		table.addCell(cell);
		table.setWidthPercentage(100);

		return table;
	}

	public static PdfPTable Tableau2(Consommation consommation) {
		PdfPTable table = new PdfPTable(5);
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Date relève "));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Index lu "));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Nombre jour "));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Volume consommé "));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Volume facturé "));
		table.addCell(cell);
		table.addCell(new PdfPCell(new Paragraph("" + consommation.getDate_releve())));
		table.addCell(new PdfPCell(new Paragraph("" + consommation.getIndex_lu())));
		table.addCell(new PdfPCell(new Paragraph("" + consommation.getNbr_jour())));
		table.addCell(new PdfPCell(new Paragraph("" + consommation.getVolume_consomme() + " Kwh")));
		table.addCell(new PdfPCell(new Paragraph("" + consommation.getVolume_facture() + " Kwh")));

		return table;
	}

	public static PdfPTable Tableau1(Demande_abonnement demande_abonnement, Contrat contrat, long idClient) {
		PdfPTable table = new PdfPTable(new float[] { 1, 1 });
		table.setWidthPercentage(55.067f);
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Tournée "));
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + demande_abonnement.getTournee()));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Contrat "));
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + contrat.getNumero()));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("N°Client "));
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + idClient));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Compteur "));
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + contrat.getNumCompteur()));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Usage "));
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + demande_abonnement.getTarif()));
		table.addCell(cell);
		return table;
	}

	public static void main(String[] args) {
		genererPdf(3, 3, 1);

	}
}
