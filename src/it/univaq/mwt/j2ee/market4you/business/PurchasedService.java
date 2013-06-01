package it.univaq.mwt.j2ee.market4you.business;

import java.util.List;

import it.univaq.mwt.j2ee.market4you.business.model.Purchased;
import it.univaq.mwt.j2ee.market4you.business.model.User;

public interface PurchasedService {
	
	void createPurchased(Purchased purchased) throws BusinessException;
	
	Purchased findPurchasedByPK(Integer id) throws BusinessException;
	
	List<Purchased> findAllPurchasedByUser(User buyer) throws BusinessException;

}

