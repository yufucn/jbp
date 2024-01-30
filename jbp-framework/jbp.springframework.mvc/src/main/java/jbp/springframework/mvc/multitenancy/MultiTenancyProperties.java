package jbp.springframework.mvc.multitenancy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
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

    private String packages;
    private Map<String, DataSourceConfig> tenants;
}
