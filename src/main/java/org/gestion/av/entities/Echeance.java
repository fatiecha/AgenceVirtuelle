package org.gestion.av.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Echeance implements Serializable{
	@Id
	
	private int ordre;
	private double montant;
	private Date date;
	private boolean etat;
	@ManyToOne
	@JoinColumn(name="code_facilite")
	private Facilite facilite;
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
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
	public Facilite getFacilite() {
		return facilite;
	}
	public void setFacilite(Facilite facilite) {
		this.facilite = facilite;
	}
	public Echeance(int ordre, double montant, Date date, boolean etat, Facilite facilite) {
		super();
		this.ordre = ordre;
		this.montant = montant;
		this.date = date;
		this.etat = etat;
		this.facilite = facilite;
	}
	public Echeance() {
		super();
	}
}
