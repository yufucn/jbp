package yufu.jbp.multitenancy;

/**
 * @author wang
 */
public interface IMultiTenant {
    String getTenantId();

    void setTenantId(String value);
}
