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
import it.univaq.mwt.j2ee.market4you.business.ProductService;
import it.univaq.mwt.j2ee.market4you.business.model.Category;
import it.univaq.mwt.j2ee.market4you.business.model.Product;
import it.univaq.mwt.j2ee.market4you.business.model.Shop;

public class JDBCProductService implements ProductService {

	private DataSource dataSource;
	
	public JDBCProductService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void createProduct(Product product) throws BusinessException {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "INSERT INTO products SET (product_id, shop_id, category_id, name, price, description, sold, published_on, " +
                        "update_on, visited_count, image_uri) VALUES (PRODUCTS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, product.getShop().getId());
			statement.setInt(2, product.getCategory().getId());
			statement.setString(3, product.getName());
			statement.setDouble(4, product.getPrice());
			statement.setString(5, product.getDescription());
			statement.setString(6, product.isSold()?"true":"false");
	// da vedere		
			statement.setDate(7, new Date(0));
			statement.setDate(8, new Date(0));
	//
			statement.setInt(9, product.getVisitedCount());
			statement.setString(10, product.getImageURI());
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
	public List<Product> findAllProductsByShopPK(Integer id) throws BusinessException {
		List<Product> products=new ArrayList<Product>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String sql= "SELECT * FROM products WHERE shop_id='"+id+"'";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Integer productId= resultSet.getInt("product_id");
				String name=resultSet.getString("name");
				double price=resultSet.getDouble("price");
				String description=resultSet.getString("description");
				boolean sold=(resultSet.getString("sold").equals("true"))?true:false;
		        Date publishedOn=resultSet.getDate("published_on");
			    Date updatedOn=resultSet.getDate("update_on");
				int visitedCount=resultSet.getInt("visited_count");
				String imageURI=resultSet.getString("image_uri");
				Shop shop=new Shop(id);
				Category category=new Category(resultSet.getInt("category_id"));
				Product product=new Product(productId, shop, category, name, price, description, sold, publishedOn, updatedOn, visitedCount, imageURI);
				products.add(product);
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
		return products;
	}

	@Override
	public Product findProductByPK(Integer id) throws BusinessException {
		Product product=null;
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String sql= "SELECT * FROM products WHERE product_id='"+id+"'";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			if (resultSet.next()) {
				String name=resultSet.getString("name");
				double price=resultSet.getDouble("price");
				String description=resultSet.getString("description");
				boolean sold=(resultSet.getString("sold").equals("true"))?true:false;
		        Date publishedOn=resultSet.getDate("published_on");
			    Date updatedOn=resultSet.getDate("update_on");
				int visitedCount=resultSet.getInt("visited_count");
				String imageURI=resultSet.getString("image_uri");
				Shop shop=new Shop(resultSet.getInt("shop_id"));
				Category category=new Category(resultSet.getInt("category_id"));
				product=new Product(id, shop, category, name, price, description, sold, publishedOn, updatedOn, visitedCount, imageURI);
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
		return product;
	}

	@Override
	public void updateProduct(Product product) throws BusinessException {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "UPDATE products SET shop_id=?, category_id=?, name=?, price=?, description=?, sold=?, published_on=?, " +
                        "update_on=?, visited_count=?, image_uri=? WHERE product_id=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, product.getShop().getId());
			statement.setInt(2, product.getCategory().getId());
			statement.setString(3, product.getName());
			statement.setDouble(4, product.getPrice());
			statement.setString(5, product.getDescription());
			statement.setString(6, product.isSold()?"true":"false");
	// da vedere		
			statement.setDate(7, new Date(0));
			statement.setDate(8, new Date(0));
	//
			statement.setInt(9, product.getVisitedCount());
			statement.setString(10, product.getImageURI());
			statement.setInt(11, product.getId());
		    
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
	public void deleteProduct(Product product) throws BusinessException {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "DELETE FROM products WHERE product_id='"+product.getId()+"'";
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
