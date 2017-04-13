package org.gestion.av.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.gestion.av.dao.IAgenceDao;
import org.gestion.av.entities.Client;
import org.gestion.av.entities.Type_reclamation;

public class AgenceDaoImpl implements IAgenceDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Type_reclamation> getlibelleTypeReclamation() {

		Query query = em.createQuery("select n from Type_reclamation n ");
		List<Type_reclamation> Type_reclamations = new ArrayList<>();

		Type_reclamations = query.getResultList();
		return Type_reclamations;

	}

	@Override
	public Client getClient(long idClient) {
		Query req = em.createQuery("select c from Client c  where id =:x");
		req.setParameter("x", idClient);
		return (Client) req.getSingleResult();
	}

	// @Override
	// public void updateClient(Client c) {
	// Query req = em.createQuery(
	// "update Client set CIN=:cin , email=:email , nom=:nom , prenom =:prenom,
	// tel =:tel, MDP=:mdp WHERE id =:id");
	// req.setParameter("cin", c.getCIN());
	// req.setParameter("email", c.getEmail());
	// req.setParameter("nom", c.getNom());
	// req.setParameter("prenom", c.getPrenom());
	// req.setParameter("tel", c.getTel());
	// req.setParameter("mdp", c.getMDP());
	// req.setParameter("id", c.getId());
	//
	// }
	@Override
	public void updateClient(Client c) {
		Query req = em.createQuery(
				"update  Client   set  nom=:nom , prenom =:prenom WHERE id =:id");
	
		req.setParameter("nom", "e");
		req.setParameter("prenom", "e");

		req.setParameter("id", 8l);

	}
}
