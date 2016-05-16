package com.cmt.model;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.cmt.factory.HibernateSessionFactory;


public class UserTest {
	/**
	 * SchemaExport
	 */
	@Test
	public void testSchemaExport(){
		Configuration config = new Configuration().configure();
		
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		
		SessionFactory factory = config.buildSessionFactory(registry);
		
		Session session = factory.getCurrentSession();
		
		SchemaExport export = new SchemaExport(config);
		
		export.create(true,true);
		
	}
	

	@Test
	public void testLog4j(){
		Logger logger = Logger.getLogger(UserTest.class);
		logger.debug("This is debug message.");  
        // 记录info级别的信息  
        logger.info("This is info message.");  
        // 记录error级别的信息  
        logger.error("This is error message.");  
	}
}
