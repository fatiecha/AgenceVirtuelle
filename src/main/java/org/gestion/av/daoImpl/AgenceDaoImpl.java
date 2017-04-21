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


	 @Override
	 public void updateClient(Client c) {
		 Client cli=em.find(Client.class, c.getId());
		 String msg=verifierMDP(c.getMDP());
		 if(msg.equals("verifie")){
			cli.setNom(c.getNom());
			cli.setPrenom(c.getPrenom());
			cli.setCIN(c.getCIN());
			cli.setEmail(c.getEmail());
			cli.setTel(c.getTel());
			cli.setMDP(c.getMDP());
		 }
	 }
	 public String verifierMDP(String mdp){
			int size=mdp.length();
			String msg="non verifie";
			if(size<=10 & size>=5){
				msg="verifie";
			}
			return msg;
			
		}
}
