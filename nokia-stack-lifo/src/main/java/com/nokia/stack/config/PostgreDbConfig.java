package com.nokia.stack.config;

import com.nokia.stack.constants.Constants;
import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * The Class PostgreDbConfig.
 */
@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
  basePackages = "com.nokia.stack.postgre.repository",
  entityManagerFactoryRef = "postgreEntityManager",
  transactionManagerRef = "postgreTransactionManager")
public class PostgreDbConfig {
  
  /** The env. */
  @Autowired
  private Environment env;

  /**
   * Postgre entity manager.
   *
   * @return the local container entity manager factory bean
   */
  @Bean(name = "postgreEntityManager")
  public LocalContainerEntityManagerFactoryBean postgreEntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(postgreDataSource());
    em.setPackagesToScan(
      Constants.POSTGRE_ENTITY_PACKAGE.getValue());

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    HashMap<String, Object> properties = new HashMap<>();
    properties.put(Constants.HIBERNATE_HBM2DDL.getValue(),
      env.getProperty("postgre.hibernate.ddl-auto"));
    properties.put(Constants.HIBERNATE_DIALECT.getValue(),
      env.getProperty("postgre.hibernate.dialect"));
    em.setJpaPropertyMap(properties);
    em.setPersistenceUnitName(Constants.POSTGRE_PERSISTENCE_UNIT_NAME.getValue());
    return em;
  }

  /**
   * Postgre data source.
   *
   * @return the data source
   */
  @Bean(name = "postgreDataSource")
  @ConfigurationProperties(prefix = "postgre.datasource")
  public DataSource postgreDataSource() {

    return DataSourceBuilder.create().build();

  }

  /**
   * Postgre transaction manager.
   *
   * @return the platform transaction manager
   */
  @Bean(name = "postgreTransactionManager")
  public PlatformTransactionManager postgreTransactionManager() {

    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(
      postgreEntityManager().getObject());
    return transactionManager;
  }
}
