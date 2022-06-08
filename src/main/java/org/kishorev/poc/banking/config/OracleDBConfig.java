package org.kishorev.poc.banking.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "oracleDgEntityManagerFactory",
        transactionManagerRef = "oracleDbTransactionManager", basePackages = {"org.kishorev.poc.banking.dao"})
public class OracleDBConfig {

    @Bean
    @ConfigurationProperties("oracledb.datasource")
    public DataSourceProperties oracleDbDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name="oracleDbDataSource")
    @ConfigurationProperties("oracledb.datasource")
    public DataSource oracleDbDataSource() {
        return oracleDbDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name="oracleDgEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("oracleDbDataSource") DataSource dataSource)  {
        return builder.dataSource(dataSource).packages("org.kishorev.poc.banking.entity").persistenceUnit("oracleDb").build();
    }

    @Bean(name="oracleDbTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("oracleDgEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
