package org.gestion.av.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Compte  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double mt_impay�;
	private double mt_exigible;
	private double credit;
	private double provision;
	@OneToOne
	
	private Contrat contrat;
	public double getMt_impay�() {
		return mt_impay�;
	}
	public void setMt_impay�(double mt_impay�) {
		this.mt_impay� = mt_impay�;
	}
	public double getMt_exigible() {
		return mt_exigible;
	}
	public void setMt_exigible(double mt_exigible) {
		this.mt_exigible = mt_exigible;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getProvision() {
		return provision;
	}
	public void setProvision(double provision) {
		this.provision = provision;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(double mt_impay�, double mt_exigible, double credit, double provision) {
		super();
		this.mt_impay� = mt_impay�;
		this.mt_exigible = mt_exigible;
		this.credit = credit;
		this.provision = provision;
	}
	
	
}