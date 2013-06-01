package it.univaq.mwt.j2ee.market4you.business;

import it.univaq.mwt.j2ee.market4you.business.model.Review;

public interface ReviewService {
	
    void createReview(Review review) throws BusinessException;
	
	void updateReview(Review review) throws BusinessException;
	
	void deleteReview(Review review) throws BusinessException;

}
