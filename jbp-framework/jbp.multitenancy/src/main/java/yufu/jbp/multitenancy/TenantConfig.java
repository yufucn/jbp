package yufu.jbp.multitenancy;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author wang
 */
@Getter
@Setter
public class TenantConfig {
    private String id;
    private String name;
    private Map<String, DataSourceConfig> dataSources;
    private Boolean active;
}
