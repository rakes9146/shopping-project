package net.rk.shopping_backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"net.rk.shopping_backend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	// CHANGE THE BELOW BASED ON THE
	private final static String DATBASE_URL = "jdbc:mysql://localhost:3306/shopping";
	private final static String DATBASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATBASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private final static String DATBASE_USERNAME = "root";
	private final static String DATBASE_PASSWORD = "root";

	// This will be the datasource bean where Database Proerpteis Will be
	// defineed
	@Bean
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		// providing the database connection information
		dataSource.setDriverClassName(DATBASE_DRIVER);
		dataSource.setUrl(DATBASE_URL);
		dataSource.setUsername(DATBASE_USERNAME);
		dataSource.setPassword(DATBASE_PASSWORD);

              return dataSource;
	}

	// This will be the session Factory Bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.rk.shopping_backend.dto");

		return builder.buildSessionFactory();

	}

	// All the hibernate properties will be returned in this method

	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", DATBASE_DIALECT);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		
		return properties;

	}

	@Bean 
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
  
		 HibernateTransactionManager m = new HibernateTransactionManager(sessionFactory);
		 return m; 
		
		
	}

}
