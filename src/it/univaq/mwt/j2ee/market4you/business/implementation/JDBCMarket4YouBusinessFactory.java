package it.univaq.mwt.j2ee.market4you.business.implementation;

import javax.sql.DataSource;

import it.univaq.mwt.j2ee.market4you.business.Market4YouBusinessFactory;
import it.univaq.mwt.j2ee.market4you.business.NewsService;
import it.univaq.mwt.j2ee.market4you.business.ProductService;
import it.univaq.mwt.j2ee.market4you.business.ReviewService;
import it.univaq.mwt.j2ee.market4you.business.UserService;

public class JDBCMarket4YouBusinessFactory extends Market4YouBusinessFactory {

	private DataSource dataSource;
	
	public JDBCMarket4YouBusinessFactory(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	@Override
	public ProductService getProductService() {
		return new JDBCProductService(dataSource);
	}
	
	public UserService getUserService() {
		return new JDBCUserService(dataSource);
	}
	
	public NewsService getNewsService() {
		return new JDBCNewsService(dataSource);
	}

	@Override
	public ReviewService getReviewService() {
		return new JDBCReviewService(dataSource);
	}
	

}
