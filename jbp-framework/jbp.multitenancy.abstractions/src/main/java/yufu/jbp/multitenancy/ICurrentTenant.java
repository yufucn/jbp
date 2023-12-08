package yufu.jbp.multitenancy;

/**
 * @author wang
 */
public interface ICurrentTenant {
    Boolean getAvailable();

    String getTenantId();

    String getTenantName();

}
