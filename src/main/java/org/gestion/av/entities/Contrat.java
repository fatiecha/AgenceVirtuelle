package org.gestion.av.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Contrat implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String service;
	private String CIN;
	private String agence;
	private String branchement;
	private String etat;
	private String numCompteur;
	private Date datePoseCompteur;

	@OneToOne
	private Demande_abonnement demande_abonnement;

	@OneToMany(mappedBy = "contrat")
	private List<Consommation> consommations;
	@OneToMany(mappedBy = "contrat")
	private List<Facilite> facilites;
	@OneToMany(mappedBy = "contrat")
	private List<Devis> devis;
	@OneToMany(mappedBy = "contrat")
	private List<Facture> factures;
	@OneToMany(mappedBy = "contrat")
	private List<Reclamation> reclamations;
	
	@ManyToMany(mappedBy="contrats")
	private List<Client> clients;

	public Contrat() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public Demande_abonnement getDemande_abonnement() {
		return demande_abonnement;
	}

	public void setDemande_abonnement(Demande_abonnement demande_abonnement) {
		this.demande_abonnement = demande_abonnement;
	}

	public List<Consommation> getConsommations() {
		return consommations;
	}

	public void setConsommations(List<Consommation> consommations) {
		this.consommations = consommations;
	}

	public List<Facilite> getFacilites() {
		return facilites;
	}

	public void setFacilites(List<Facilite> facilites) {
		this.facilites = facilites;
	}

	public List<Devis> getDevis() {
		return devis;
	}

	public void setDevis(List<Devis> devis) {
		this.devis = devis;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getBranchement() {
		return branchement;
	}

	public void setBranchement(String branchement) {
		this.branchement = branchement;
	}

	public String isEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getNumCompteur() {
		return numCompteur;
	}

	public void setNumCompteur(String numCompteur) {
		this.numCompteur = numCompteur;
	}

	public Date getDatePoseCompteur() {
		return datePoseCompteur;
	}

	public void setDatePoseCompteur(Date datePoseCompteur) {
		this.datePoseCompteur = datePoseCompteur;
	}

	public String getEtat() {
		return etat;
	}

	public Contrat(Date date, String service, String cIN, String agence, String branchement, String etat,
			String numCompteur, Date datePoseCompteur, Demande_abonnement demande_abonnement) {
		super();
		this.date = date;
		this.service = service;
		CIN = cIN;
		this.agence = agence;
		this.branchement = branchement;
		this.etat = etat;
		this.numCompteur = numCompteur;
		this.datePoseCompteur = datePoseCompteur;
		this.demande_abonnement = demande_abonnement;
	}



	

}
