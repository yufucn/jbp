package yufu.jbp.multitenancy.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import yufu.jbp.multitenancy.DataSourceConfig;

import java.util.Map;

/**
 * @author wang
 */
@Configuration
@Getter
@Setter
public class MultiTenancyProperties {

    @Value("${multitenancy.packages}")
    private String packages;

    @Value("${multitenancy.tenants}")
    private Map<String, DataSourceConfig> tenants;
}
