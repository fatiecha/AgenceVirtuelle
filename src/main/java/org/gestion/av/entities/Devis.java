package org.gestion.av.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Devis implements Serializable{
	@Id
	@GeneratedValue
	private long id;
	private Date date;
	private boolean etat;
	private double montant;
	private String commentaire;
	@ManyToOne
	@JoinColumn(name="code_contrat")
	private Contrat contrat;
	public Devis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Devis(Date date, boolean etat, double montant, String commentaire, Contrat contrat) {
		super();
		this.date = date;
		this.etat = etat;
		this.montant = montant;
		this.commentaire = commentaire;
		this.contrat = contrat;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	
}