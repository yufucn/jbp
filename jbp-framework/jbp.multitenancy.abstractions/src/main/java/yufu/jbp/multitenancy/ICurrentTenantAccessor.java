package yufu.jbp.multitenancy;

/**
 * @author wang
 */
public interface ICurrentTenantAccessor {
    BasicTenantInfo getCurrent();

    void setCurrent(BasicTenantInfo current);
}
