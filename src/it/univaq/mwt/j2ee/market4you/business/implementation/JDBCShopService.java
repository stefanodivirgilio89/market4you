package it.univaq.mwt.j2ee.market4you.business.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import it.univaq.mwt.j2ee.market4you.business.BusinessException;
import it.univaq.mwt.j2ee.market4you.business.ShopService;
import it.univaq.mwt.j2ee.market4you.business.model.Shop;
import it.univaq.mwt.j2ee.market4you.business.model.User;

public class JDBCShopService implements ShopService {

	private DataSource dataSource;
	
	public JDBCShopService(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public void updateShopInformation(Shop shop) throws BusinessException {
		
		// lo username non si può cambiare, solo un utente ha generato quel mercatino
		//neanche rating, poichè è generato da tutti i voti degli utenti
		
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "UPDATE shops SET name=?, country=?, address=?, postcode=?, telephone=?, city=? WHERE " +
					 "shop_id=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, shop.getName());
			statement.setString(2, shop.getCountry());
			statement.setString(3, shop.getAddress());
			statement.setString(4, shop.getPostcode());
			statement.setString(5, shop.getTelephone());
			statement.setString(6, shop.getCity());
			statement.setInt(7, shop.getId());
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
	public Shop findShopByPK(Integer id) throws BusinessException {
		Shop shop=null;
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String sql= "SELECT * FROM shops WHERE shop_id='"+id+"'";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			if (resultSet.next()) {
				String name=resultSet.getString("name");
				String country=resultSet.getString("country");
				String address=resultSet.getString("address");
				String postcode=resultSet.getString("postcode");
				String telephone=resultSet.getString("telephone");
				String city=resultSet.getString("city");
				int rating=resultSet.getInt("rating");
				User user=new User(resultSet.getString("username"));
				shop=new Shop(id, user, name, country, address, postcode, telephone, city, rating);
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
		return shop;
	}

	@Override
	public List<Shop> findAllShopsByCity(String city) throws BusinessException {
		List<Shop> shops=new ArrayList<Shop>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String sql= "SELECT * FROM shops WHERE city='"+city+"'";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Integer id=resultSet.getInt("shop_id");
				String name=resultSet.getString("name");
				String country=resultSet.getString("country");
				String address=resultSet.getString("address");
				String postcode=resultSet.getString("postcode");
				String telephone=resultSet.getString("telephone");
				int rating=resultSet.getInt("rating");
				User user=new User(resultSet.getString("username"));
				Shop shop=new Shop(id, user, name, country, address, postcode, telephone, city, rating);
				shops.add(shop);
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
		return shops;
	}

	@Override
	public void createShop(Shop shop) throws BusinessException {
		
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "INSERT INTO shops SET (shop_id, username, name, country, address, postcode, telephone, city, rating)" +
					" VALUES (SHOPS_SEQ.NEXTVAL,?,?,?,?,?,?,?,NULL)"; // IL RATING ALL'INIZIO È NULLO
			statement=connection.prepareStatement(sql);
			statement.setString(1, shop.getUser().getUsername());
			statement.setString(2, shop.getName());
			statement.setString(3, shop.getCountry());
			statement.setString(4, shop.getAddress());
			statement.setString(5, shop.getPostcode());
			statement.setString(6, shop.getTelephone());
			statement.setString(7, shop.getCity());
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

}