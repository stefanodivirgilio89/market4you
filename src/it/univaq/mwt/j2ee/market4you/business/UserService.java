package it.univaq.mwt.j2ee.market4you.business;

import it.univaq.mwt.j2ee.market4you.business.model.User;

public interface UserService {
	
	void createUser(User user) throws BusinessException;
	
	void updateUser(User user) throws BusinessException;
	
	void deleteUser(User user) throws BusinessException;

}
