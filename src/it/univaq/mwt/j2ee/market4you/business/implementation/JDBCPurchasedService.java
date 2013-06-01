package it.univaq.mwt.j2ee.market4you.business.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;
import it.univaq.mwt.j2ee.market4you.business.BusinessException;
import it.univaq.mwt.j2ee.market4you.business.PurchasedService;
import it.univaq.mwt.j2ee.market4you.business.model.Product;
import it.univaq.mwt.j2ee.market4you.business.model.Purchased;
import it.univaq.mwt.j2ee.market4you.business.model.Review;
import it.univaq.mwt.j2ee.market4you.business.model.User;

public class JDBCPurchasedService implements PurchasedService {

	private DataSource dataSource;
	
	public JDBCPurchasedService(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public void createPurchased(Purchased purchased) throws BusinessException {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "INSERT INTO purchased SET (purchased_id, product_id, username, review_id, order_date, price, score) " +
					"VALUES (PURCHASED_SEQ.NEXTVAL,?,?,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, purchased.getProduct().getId());
			statement.setString(2, purchased.getBuyer().getUsername());
			statement.setInt(3, purchased.getReview().getId());
	//		statement.setDate(4, purchased.getOrderDate());    da vedere
			statement.setDouble(5, purchased.getPrice());
			statement.setInt(6, purchased.getScore());
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
	public Purchased findPurchasedByPK(Integer id) throws BusinessException {
		Purchased purchased=null;
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String sql= "SELECT * FROM purchased WHERE purchased_id='"+id+"'";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			if (resultSet.next()) {
			//  Date orderDate=resultSet.getDate("order_date");     da vedere, intanto:
				Date orderDate=null;
				double price=resultSet.getDouble("price");
				int score=resultSet.getInt("score");
				Product product= new Product(resultSet.getInt("product_id"));
				User buyer=new User(resultSet.getString("username"));
				Review review=new Review(resultSet.getInt("review_id"));
				purchased=new Purchased(id, product, buyer, review, orderDate, price, score);
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				}
			}
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
		return purchased;
	}

	@Override
	public List<Purchased> findAllPurchasedByUser(User buyer)
			throws BusinessException {
		
		List<Purchased> results=new ArrayList<Purchased>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String sql= "SELECT * FROM purchased WHERE username='"+buyer.getUsername()+"'";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Integer purchasedId=resultSet.getInt("purchased_id");
			//	Date orderDate=resultSet.getDate("order_date");  da vedere, intanto:
				Date orderDate=null;
				double price=resultSet.getDouble("price");
				int score=resultSet.getInt("score");
				Product product= new Product(resultSet.getInt("product_id"));
				Review review=new Review(resultSet.getInt("review_id"));
				Purchased purchased=new Purchased(purchasedId, product, buyer, review, orderDate, price, score);
				results.add(purchased);
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				}
			}
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
		return results;
		
	}

}
