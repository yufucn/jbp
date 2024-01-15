package yufu.jbp.multitenancy;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wang
 */
@Getter
@Setter
public class DataSourceConfig {
    private String driverClassName;
    private String url;
    private String userName;
    private String password;
}
