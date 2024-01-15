package yufu.jbp.multitenancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author wang
 */
@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {

    private final MultiTenancyProperties multiTenancyProperties;

    public DynamicDataSource(MultiTenancyProperties multiTenancyProperties) {
        this.multiTenancyProperties = multiTenancyProperties;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return TenantContext.getCurrentTenant();
    }

    @Override
    protected DataSource determineTargetDataSource() {
        String currentTenant = TenantContext.getCurrentTenant();
        DataSourceConfig config = multiTenancyProperties.getTenants().get(currentTenant);
        DataSource dataSource = DataSourceProvider.createDataSource(config);
        return dataSource;
    }
}
