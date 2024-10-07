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
@EnableJpaRepositories(basePackages = "com.nt.repository.prod", entityManagerFactoryRef = "oraEMF", transactionManagerRef = "oraTxMgmr")
public class OracleDBConfig {

	
	//DataSource obj
	@Bean("OraDs")
	@ConfigurationProperties(prefix = "ora.ds")
	@Primary
	public DataSource createOraDs() {
		return DataSourceBuilder.create().build();
	}
	
	
	//LocalContainerEntityManagerFactoryBean that gives EntityManagerFactory obj
	@Bean("oraEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createOracleEntityManagerFactoryBean(EntityManagerFactoryBuilder emBilder) {
		//create map object having HB properties
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.fomat_sql", "true");
		//create LocalContainerEntityManagerFactoryBean class obj using EntityManagerFactoryBuilder obj
	return emBilder.dataSource(createOraDs()).packages("com.nt.entity.prod").properties(props).build();	
	}
	
	@Bean("oraTxMgmr")
	@Primary
	public JpaTransactionManager createOracleTxMgmr(@Qualifier("oraEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
	
	
}//class
