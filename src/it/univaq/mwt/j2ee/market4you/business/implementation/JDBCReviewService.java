package it.univaq.mwt.j2ee.market4you.business.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import it.univaq.mwt.j2ee.market4you.business.BusinessException;
import it.univaq.mwt.j2ee.market4you.business.ReviewService;
import it.univaq.mwt.j2ee.market4you.business.model.Review;

public class JDBCReviewService implements ReviewService {

	private DataSource dataSource;
	
	public JDBCReviewService(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	@Override
	public void createReview(Review review) throws BusinessException {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "INSERT INTO reviews SET (review_id, body, date_added) VALUES (NEWS_SEQ.NEXTVAL,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setString(1, review.getBody());
		// da vedere	statement.setString(2, review.getDateAdded());
			statement.executeUpdate();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		
		
		
	}

	@Override
	public void updateReview(Review review) throws BusinessException {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "UPDATE reviews SET body=?, date_added=? WHERE review_id=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, review.getBody());
		// da vedere	statement.setString(2, review.getDateAdded());
			statement.setInt(3, review.getId());
			statement.executeUpdate();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		
	}

	@Override
	public void deleteReview(Review review) throws BusinessException {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "DELETE FROM reviews WHERE review_id='"+review.getId()+"'";
			statement=connection.createStatement();
			statement.executeUpdate(sql);
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		
	}
	
	

}
