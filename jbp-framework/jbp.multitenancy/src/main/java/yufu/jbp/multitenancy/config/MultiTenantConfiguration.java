package yufu.jbp.multitenancy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import yufu.jbp.multitenancy.DataSourceConfig;
import yufu.jbp.multitenancy.MultiTenantDataSource;
import yufu.jbp.multitenancy.config.MultiTenancyProperties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wang
 */
@Configuration
public class MultiTenantConfiguration {

    private MultiTenancyProperties multiTenancyProperties;

    public MultiTenantConfiguration(MultiTenancyProperties multiTenancyProperties) {
        this.multiTenancyProperties = multiTenancyProperties;
    }


    @Bean(name = "routingDataSource")
    public MultiTenantDataSource routingDataSource() {
        Map<Object, Object> resolvedDataSources = new HashMap<>();
        Map<String, DataSourceConfig> tenants = multiTenancyProperties.getTenants();
        tenants.forEach((key, value) -> {
            resolvedDataSources.put(key, createDataSource(value));
        });
        MultiTenantDataSource dataSource = new MultiTenantDataSource();
        dataSource.setDefaultTargetDataSource(resolvedDataSources.get(tenants.get("master")));
        dataSource.setTargetDataSources(resolvedDataSources);
        return dataSource;
    }

    private DataSource createDataSource(DataSourceConfig config) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(config.getDriverClassName());
        dataSource.setUrl(config.getUrl());
        dataSource.setUsername(config.getUserName());
        dataSource.setPassword(config.getPassword());
        return dataSource;
    }


//    @Primary
//    @Bean(name = "dataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }



}
