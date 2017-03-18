package org.gestion.av.metier;

import java.util.List;

import org.gestion.av.dao.IAgenceDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AgenceMetierImpl implements IAgenceMetier{
	private IAgenceDao dao;

	public void setDao(IAgenceDao dao) {
		this.dao = dao;
	}
	

	
	

}
