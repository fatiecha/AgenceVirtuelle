package org.gestion.av.service;

import java.util.List;

import org.gestion.av.entities.Client;
import org.gestion.av.entities.Type_reclamation;

public interface IAgenceService {

	public List<Type_reclamation> getlibelleTypeReclamation();

	public Client getClient(long idClient);
	public void updateClient(Client c );

}
