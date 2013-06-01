package it.univaq.mwt.j2ee.market4you.business;


public abstract class Market4YouBusinessFactory {
	
	private static Market4YouBusinessFactory instance;
	
	public static Market4YouBusinessFactory getInstance() {
		return instance;
	}
	
	public static void setInstance(Market4YouBusinessFactory factory) {
		instance=factory;
	}

	public abstract ProductService getProductService();
	
	public abstract UserService getUserService();
	
	public abstract NewsService getNewsService();
	
	public abstract ReviewService getReviewService();
	
}
