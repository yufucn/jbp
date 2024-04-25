package yufu.jbp.multitenancy;

/**
 * @author wang
 */
public interface MultiTenant {
    String getTenantId();

    void setTenantId(String value);
}
