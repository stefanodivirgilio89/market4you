package it.univaq.mwt.j2ee.market4you.business;

import java.util.List;

import it.univaq.mwt.j2ee.market4you.business.model.News;

public interface NewsService {
	
	void createNews(News news) throws BusinessException;
	
	void updateNews(News news) throws BusinessException;
	
	void deleteNews(News news) throws BusinessException;
	
	News findNewsByPK(Integer id) throws BusinessException;
	
	List<News> findAllNewsByShopPK(Integer id) throws BusinessException;

}
