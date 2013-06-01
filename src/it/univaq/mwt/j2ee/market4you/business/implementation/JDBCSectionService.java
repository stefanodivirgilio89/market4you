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
import it.univaq.mwt.j2ee.market4you.business.SectionService;
import it.univaq.mwt.j2ee.market4you.business.model.Section;
import it.univaq.mwt.j2ee.market4you.business.model.SectionKind;
import it.univaq.mwt.j2ee.market4you.business.model.Shop;

public class JDBCSectionService implements SectionService {

	private DataSource dataSource;
	
	public JDBCSectionService(DataSource dataSource)  {
		this.dataSource=dataSource;
	}
	
	public void updateSection(Section section) throws BusinessException {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection=dataSource.getConnection();
			String sql= "UPDATE sections SET title=?, body=?, section_kind_id=?, shop_id=? WHERE section_id=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1, section.getTitle());
			statement.setString(2, section.getBody());
			statement.setInt(3, section.getSectionKind().getId());
			statement.setInt(4, section.getShop().getId());
			statement.setInt(5, section.getId());
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
	public Section findSectionByPK(Integer id) throws BusinessException {
		Section section=null;
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String sql= "SELECT * FROM sections WHERE section_id='"+id+"'";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			if (resultSet.next()) {
				String title=resultSet.getString("title");
				String body=resultSet.getString("body");
				Shop shop=new Shop(resultSet.getInt("shop_id"));
				SectionKind sectionKind=new SectionKind(resultSet.getInt("section_kind_id"));
				section=new Section(id, title, body, shop, sectionKind);
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
		return section;
	}

	@Override
	public List<Section> findAllSectionsByShop(Shop shop) throws BusinessException {
		List<Section> sections=new ArrayList<Section>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String sql= "SELECT * FROM sections WHERE shop_id='"+shop.getId()+"'";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Integer sectionId=resultSet.getInt("section_id");
				String title=resultSet.getString("title");
				String body=resultSet.getString("body");
				SectionKind sectionKind=new SectionKind(resultSet.getInt("section_kind_id"));
			    Section section=new Section(sectionId, title, body, shop, sectionKind);
				sections.add(section);
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
		return sections;
	}
}