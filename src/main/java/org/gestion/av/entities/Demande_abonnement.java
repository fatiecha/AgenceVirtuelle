package org.gestion.av.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Demande_abonnement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private  Long tournee;
	private Date date;
	@ManyToOne
	@JoinColumn(name="code_client")
	private Client client;
	@OneToOne(mappedBy="demande_abonnement")
	private Contrat contrat;
	public Demande_abonnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Demande_abonnement(Long tournee, Date date, Client client) {
		super();
		this.tournee = tournee;
		this.date = date;
		this.client = client;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTournee() {
		return tournee;
	}
	public void setTournee(Long tournee) {
		this.tournee = tournee;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	
}