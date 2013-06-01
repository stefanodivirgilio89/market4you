package it.univaq.mwt.j2ee.market4you.business;

import java.util.List;

import it.univaq.mwt.j2ee.market4you.business.model.Product;

public interface ProductService {
	
	void createProduct(Product product) throws BusinessException;

	List<Product> findAllProductsByShopPK(Integer id) throws BusinessException;
	
	Product findProductByPK(Integer id) throws BusinessException;
	
	void updateProduct(Product product) throws BusinessException;
	
	void deleteProduct(Product product) throws BusinessException;

}
