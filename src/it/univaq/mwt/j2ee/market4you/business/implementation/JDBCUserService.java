package it.univaq.mwt.j2ee.market4you.business.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import it.univaq.mwt.j2ee.market4you.business.BusinessException;
import it.univaq.mwt.j2ee.market4you.business.UserService;
import it.univaq.mwt.j2ee.market4you.business.model.User;

public class JDBCUserService implements UserService {

	private DataSource dataSource;
	
	public JDBCUserService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void createUser(User user) throws BusinessException {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "INSERT INTO users SET (username, password, token_id, name, surname, country, state, street, postcode, " +
                        "telephone, city, email, sex, birthday, personal_number) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setInt(3, user.getToken().getId());
			statement.setString(4, user.getName());
			statement.setString(5, user.getSurname());
			statement.setString(6, user.getCountry());		
			statement.setString(7, user.getState());
			statement.setString(9, user.getStreet());
			statement.setString(8, user.getPostcode());
			statement.setString(10, user.getTelephone());
			statement.setString(11, user.getCity());
			statement.setString(12, user.getEmail());
			statement.setString(13, user.getSex());
			// da vedere
			//statement.setString(14, user.getBirthday());
			//
		    statement.setString(15, user.getPersonalNumber());
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
	public void updateUser(User user) throws BusinessException {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "UPDATE users SET password=?, token_id=?, name=?, surname=?, country=?, state=?, street=?," +
					 "postcode=?, telephone=?, city=?, email=?, sex=?, birthday=?, personal_number=?) WHERE username=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, user.getPassword());
			statement.setInt(2, user.getToken().getId());
			statement.setString(3, user.getName());
			statement.setString(4, user.getSurname());
			statement.setString(5, user.getCountry());		
			statement.setString(6, user.getState());
			statement.setString(7, user.getStreet());
			statement.setString(8, user.getPostcode());
			statement.setString(9, user.getTelephone());
			statement.setString(10, user.getCity());
			statement.setString(11, user.getEmail());
			statement.setString(12, user.getSex());
			// da vedere
			//statement.setString(13, user.getBirthday());
			//
		    statement.setString(14, user.getPersonalNumber());
		    statement.setString(15, user.getUsername());
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
	public void deleteUser(User user) throws BusinessException {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "DELETE FROM users WHERE user_id='"+user.getUsername()+"'";
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
