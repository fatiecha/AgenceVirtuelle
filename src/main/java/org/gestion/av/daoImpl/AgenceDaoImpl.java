package org.gestion.av.daoImpl;

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
		Query req=em.createQuery("select * from type_reclamation");
		return req.getResultList();	}

	@Override
	public Client getClient(long idClient) {
		Query req=em.createQuery("select * from client where id =:x");
		req.setParameter("x", idClient);
		return (Client) req.getSingleResult();
	}

}
