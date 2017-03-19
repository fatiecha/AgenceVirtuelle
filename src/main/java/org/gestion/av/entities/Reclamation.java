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
public class Reclamation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String origine;
	private Boolean etat;
	private String commentaire;
	@ManyToOne
	@JoinColumn(name = "code_type_reclamation")
	private Type_reclamation type_reclamation;
	@ManyToOne
	@JoinColumn(name = "code_contrat")
	private Contrat contrat;

	public Reclamation() {
		super();
	}

	public Reclamation(Date date, String origine, Boolean etat, String commentaire, Type_reclamation type_reclamation,
			Contrat contrat) {
		super();
		this.date = date;
		this.origine = origine;
		this.etat = etat;
		this.commentaire = commentaire;
		this.type_reclamation = type_reclamation;
		this.contrat = contrat;
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

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Type_reclamation getType_reclamation() {
		return type_reclamation;
	}

	public void setType_reclamation(Type_reclamation type_reclamation) {
		this.type_reclamation = type_reclamation;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

}
