package main.java.com.ak.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource(value="classpath:hibernate.properties")
@EnableJpaRepositories(basePackages = "com.ak.dao")
public class HibernateConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setPassword(environment.getRequiredProperty("jdbc.properties"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.user.name"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.driver.class.name"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.url"));
		
		return dataSource;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory(){
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		properties.put("hibernate.generate_statistic", environment.getProperty("hibernate.generate_statistic"));
		
		LocalContainerEntityManagerFactoryBean factorybean = new LocalContainerEntityManagerFactoryBean();
		factorybean.setPackagesToScan("com.ak.model");
		factorybean.setJpaProperties(properties);
		factorybean.setDataSource(dataSource());
		
		factorybean.afterPropertiesSet();
		
		return factorybean.getObject();
		
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory());
		
		return transactionManager;
	}
}
