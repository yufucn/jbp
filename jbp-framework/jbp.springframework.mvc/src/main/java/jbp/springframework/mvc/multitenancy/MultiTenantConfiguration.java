package jbp.springframework.mvc.multitenancy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import yufu.jbp.multitenancy.MultiTenantDataSource;

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
//        dataSource.setDefaultTargetDataSource(resolvedDataSources.get(tenants.get("master")));
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
}
