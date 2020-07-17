package com.chan.spring.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.chan.spring")
@EnableTransactionManagement
public class ApplicationConfig {
	
	//datasource
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:hsqldb:mem:text");
		ds.setUsername("sa");
		ds.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
		return ds;
	}
	
	// entity manager factory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPersistenceUnitName("spring-orm1");
		emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return emf;
	}
	
	// transaction manager
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager tx = new JpaTransactionManager(entityManagerFactory);
		return tx;
	}

}
