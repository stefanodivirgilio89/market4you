package it.univaq.mwt.j2ee.market4you.presentation.common;

import it.univaq.mwt.j2ee.market4you.business.Market4YouBusinessFactory;
import it.univaq.mwt.j2ee.market4you.business.implementation.JDBCMarket4YouBusinessFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class Market4YouServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = ( Context ) initCtx.lookup( "java:comp/env" );
			DataSource dataSource = ( DataSource ) envCtx.lookup( "jdbc/market4youdb" );	
			Market4YouBusinessFactory.setInstance(new JDBCMarket4YouBusinessFactory(dataSource));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
