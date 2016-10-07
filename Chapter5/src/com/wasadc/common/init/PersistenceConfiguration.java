/**
 * 
 */
package com.wasadc.common.init;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Juliano Cassoli
 *
 */
@Configuration
@EnableJpaRepositories(basePackages="com.wasadc.domain")
@EnableTransactionManagement
public class PersistenceConfiguration {
	
	private static final Logger logger = LogManager.getLogger(PersistenceConfiguration.class);
	
	public static final String HIBERNATE_LOCAL_SESSION_SCAN = "com.wasadc";
	public static final String DOMAIN_ENTITY_SCAN = "com.wasadc.domain";

	@Value("${jdbc.driverClassName}") private String driverClassName;
	@Value("${jdbc.url}") private String url;
	@Value("${jdbc.schema}") private String schema;
	@Value("${jdbc.username}") private String username;
	@Value("${jdbc.password}") private String password;
	
	@Value("${hibernate.dialect}") private String hibernateDialect;
	@Value("${hibernate.show_sql}") private String hibernateShowSql;
	@Value("${hibernate.format_sql}") private String hibernateFormatSql;
	@Value("${hibernate.use_sql_comments}") private String hibernateCommentSql;
	@Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2ddlAuto;
	
	@Value("${hibernate.c3p0.acquireIncrement}") private String hibernateC3P0AcquireIncrement;
	@Value("${hibernate.c3p0.min_size}") private String hibernateC3P0MinSize;
	@Value("${hibernate.c3p0.max_size}") private String hibernateC3P0MaxSize;
	@Value("${hibernate.c3p0.max_idletime}") private String hibernateC3P0MaxIdleTime;
	@Value("${hibernate.c3p0.max_statements}") private String hibernateC3P0MaxStatements;

	@Value("${jpa.database.name}") private String databaseName;
	
	@Bean()
	public javax.sql.DataSource getDataSource() {

		ComboPooledDataSource ds = new ComboPooledDataSource();

		try {
			ds.setDriverClass(driverClassName);
			ds.setJdbcUrl(url);
			ds.setUser(username);
			ds.setPassword(password);

			ds.setAcquireIncrement(Integer.parseInt(hibernateC3P0AcquireIncrement));
			ds.setMinPoolSize(Integer.parseInt(hibernateC3P0MinSize));
			ds.setMaxPoolSize(Integer.parseInt(hibernateC3P0MaxSize));
			ds.setMaxIdleTime(Integer.parseInt(hibernateC3P0MaxIdleTime));
			ds.setMaxStatementsPerConnection(Integer.parseInt(hibernateC3P0MaxStatements));
			
		} catch (NumberFormatException | PropertyVetoException e) {
			logger.error("Could not create DataSource: " + e.getMessage());
		}

		return ds;
	}
    
    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.format_sql", hibernateFormatSql);
        properties.put("hibernate.use_sql_comments", hibernateCommentSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        if(schema != null && !schema.isEmpty()){
        	properties.put("hibernate.default_schema", schema);	 
        }
		properties.put("sequence", "custom_hibernate_seq");
        
        return properties;
    }
    
    
    /**
     * Entity Manager Factory to Spring JPA with Hibernate Adapter
     * 
     * @param dataSource
     * @return
     */
    @Bean
    @Autowired
    public AbstractEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

    	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    	vendorAdapter.setDatabase(Database.valueOf(databaseName));
    	vendorAdapter.setGenerateDdl(true);
    	
    	LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    	factory.setJpaVendorAdapter(vendorAdapter);
    	factory.setPackagesToScan(DOMAIN_ENTITY_SCAN);
    	factory.setDataSource(dataSource);
    	factory.setJpaProperties(getHibernateProperties());
		
    	return factory;
    }
    
    /**
     * Transaction Manager to Spring JPA
     * 
     * @param emf
     * @return
     */
    @Bean
    @Autowired
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
    	if(emf==null) return null;
    	JpaTransactionManager tm = new JpaTransactionManager();
    	tm.setEntityManagerFactory(emf);
    	return tm;
    }
    
    
}
