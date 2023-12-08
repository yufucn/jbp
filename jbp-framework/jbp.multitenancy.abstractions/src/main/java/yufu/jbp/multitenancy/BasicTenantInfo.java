package yufu.jbp.multitenancy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wang
 */
@Getter
@Setter
@ToString
public class BasicTenantInfo {
    private String tenantId;
    private String tenantName;
}
