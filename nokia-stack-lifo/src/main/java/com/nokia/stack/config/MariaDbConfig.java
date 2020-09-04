package com.nokia.stack.config;

import com.nokia.stack.constants.Constants;
import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * The Class MariaDbConfig.
 */
@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
  basePackages = "com.nokia.stack.maria.repository",
  entityManagerFactoryRef = "mariaEntityManager",
  transactionManagerRef = "mariaTransactionManager")
public class MariaDbConfig {

  /** The env. */
  @Autowired
  private Environment env;

  /**
   * Maria entity manager.
   *
   * @return the local container entity manager factory bean
   */
  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean mariaEntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(mariaDataSource());
    em.setPackagesToScan(Constants.MARIA_ENTITY_PACKAGE.getValue());

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    HashMap<String, Object> properties = new HashMap<>();
    properties.put(Constants.HIBERNATE_HBM2DDL.getValue(),
      env.getProperty("maria.hibernate.ddl-auto"));
    properties.put(Constants.HIBERNATE_DIALECT.getValue(),
      env.getProperty("maria.hibernate.dialect"));
    em.setJpaPropertyMap(properties);
    em.setPersistenceUnitName(Constants.MARIA_PERSISTENCE_UNIT_NAME.getValue());
    return em;
  }

  /**
   * Maria data source.
   *
   * @return the data source
   */
  @Primary
  @Bean(name = "mariaDataSource")
  @ConfigurationProperties(prefix = "maria.datasource")
  public DataSource mariaDataSource() {

    return DataSourceBuilder.create().build();

  }

  /**
   * Maria transaction manager.
   *
   * @return the platform transaction manager
   */
  @Primary
  @Bean
  public PlatformTransactionManager mariaTransactionManager() {

    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(
      mariaEntityManager().getObject());
    return transactionManager;
  }
}
