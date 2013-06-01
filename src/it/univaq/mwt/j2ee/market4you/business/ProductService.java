package it.univaq.mwt.j2ee.market4you.business;

import java.util.List;

import it.univaq.mwt.j2ee.market4you.business.model.Category;
import it.univaq.mwt.j2ee.market4you.business.model.Product;
import it.univaq.mwt.j2ee.market4you.business.model.Shop;

public interface ProductService {
	
	void createProduct(Product product) throws BusinessException;

	List<Product> findAllProductsByShop(Shop shop) throws BusinessException;
	
	Product findProductByPK(Integer id) throws BusinessException;
	
	void updateProduct(Product product) throws BusinessException;
	
	void deleteProduct(Product product) throws BusinessException;
	
	List<Product> findAllProductsByCategory(Category category) throws BusinessException;
	
	List<Product> findAllProductsByShopAndByCategory(Shop shop, Category category) throws BusinessException;

}
