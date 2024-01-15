package yufu.jbp.multitenancy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wang
 */
@Component
@ConfigurationProperties(prefix = "multitenancy")
@Getter
@Setter
public class MultiTenancyProperties {

    private Map<String, DataSourceConfig> tenants;
}
