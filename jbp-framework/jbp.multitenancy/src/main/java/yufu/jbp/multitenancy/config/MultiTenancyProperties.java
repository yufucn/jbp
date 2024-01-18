package yufu.jbp.multitenancy.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import yufu.jbp.multitenancy.DataSourceConfig;

import java.util.Map;

/**
 * @author wang
 */
@Component
@ConfigurationProperties(prefix = "multitenancy")
@Getter
@Setter
public class MultiTenancyProperties {

    private String packages;
    private Map<String, DataSourceConfig> tenants;
}
