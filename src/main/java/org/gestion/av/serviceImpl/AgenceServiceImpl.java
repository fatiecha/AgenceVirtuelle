package org.gestion.av.serviceImpl;

import java.util.List;

import org.gestion.av.dao.IAgenceDao;
import org.gestion.av.entities.Client;
import org.gestion.av.entities.Type_reclamation;
import org.gestion.av.service.IAgenceService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AgenceServiceImpl implements IAgenceService {
	private IAgenceDao dao;

	
	public void setDao(IAgenceDao dao) {
		this.dao = dao;
	}

	

	@Override
	public List<Type_reclamation> getlibelleTypeReclamation() {
		return dao.getlibelleTypeReclamation();
	}

	@Override
	public Client getClient(long idClient) {

		return dao.getClient(idClient);
	}



	@Override
	public boolean updateClient(Client c) {
		
		return dao.updateClient(c);
	}
}
