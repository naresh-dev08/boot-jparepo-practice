package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repository.offers", entityManagerFactoryRef = "mysqlEMF", transactionManagerRef = "mysqlTxMgmr")
public class MySQLDBConfig {

	
	//DataSource obj
	@Bean("mysqlDs")
	@ConfigurationProperties(prefix = "mysql.ds")
	//@Primary
	public DataSource createMySQLDs() {
		return DataSourceBuilder.create().build();
	}
	
	
	//LocalContainerEntityManagerFactoryBean that gives EntityManagerFactory obj
	@Bean("mysqlEMF")
	//@Primary
	public LocalContainerEntityManagerFactoryBean createMySQLEntityManagerFactoryBean(EntityManagerFactoryBuilder emBilder) {
		//create map object having HB properties
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.fomat_sql", "true");
		//create LocalContainerEntityManagerFactoryBean class obj using EntityManagerFactoryBuilder obj
	return emBilder.dataSource(createMySQLDs()).packages("com.nt.entity.offers").properties(props).build();	
	}
	
	@Bean("mysqlTxMgmr")
	//@Primary
	public JpaTransactionManager createMySQLTxMgmr(@Qualifier("mysqlEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
	
	
}//class
