package it.univaq.mwt.j2ee.market4you.business;

import java.util.List;
import it.univaq.mwt.j2ee.market4you.business.model.Shop;

public interface ShopService {
	
	void updateShopInformation(Shop shop) throws BusinessException;  //Info di base sul negozio (nome, telefono ecc...)

	Shop findShopByPK(Integer id) throws BusinessException;
	
	List<Shop> findAllShopsByCity(String city) throws BusinessException;
	
	void createShop(Shop shop) throws BusinessException;
	
	
}
