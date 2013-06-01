package it.univaq.mwt.j2ee.market4you.business.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import it.univaq.mwt.j2ee.market4you.business.BusinessException;
import it.univaq.mwt.j2ee.market4you.business.NewsService;
import it.univaq.mwt.j2ee.market4you.business.model.Category;
import it.univaq.mwt.j2ee.market4you.business.model.News;
import it.univaq.mwt.j2ee.market4you.business.model.Product;
import it.univaq.mwt.j2ee.market4you.business.model.Shop;

public class JDBCNewsService implements NewsService {

	private DataSource dataSource;
	
	public JDBCNewsService(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	@Override
	public void createNews(News news) throws BusinessException {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "INSERT INTO news SET (news_id, shop_id, title, body) VALUES (NEWS_SEQ.NEXTVAL,?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, news.getShop().getId());
			statement.setString(2, news.getTitle());
			statement.setString(3, news.getBody());
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
	public void updateNews(News news) throws BusinessException {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "UPDATE news SET shop_id=?, title=?, body=? WHERE news_id=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, news.getShop().getId());
			statement.setString(2, news.getTitle());
			statement.setString(3, news.getBody());
			statement.setInt(4, news.getId());
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
	public void deleteNews(News news) throws BusinessException {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "DELETE FROM news WHERE news_id='"+news.getId()+"'";
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
	@Override
	public News findNewsByPK(Integer id) throws BusinessException {
		News news=null;
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String sql= "SELECT * FROM news WHERE news_id='"+id+"'";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			if (resultSet.next()) {
				String title=resultSet.getString("title");
				String body=resultSet.getString("body");
				Shop shop=new Shop(resultSet.getInt("shop_id"));
				news=new News(id, title, body, shop);
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
		return news;
	}
	@Override
	public List<News> findAllNewsByShopPK(Integer id) throws BusinessException {
		List<News> results=new ArrayList<News>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String sql= "SELECT * FROM news WHERE shop_id='"+id+"'";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Integer newsId=resultSet.getInt("news_id");
				String title=resultSet.getString("title");
				String body=resultSet.getString("body");
				Shop shop=new Shop(id);
				News news=new News(newsId, title, body, shop);
				results.add(news);
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
