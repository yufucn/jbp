package yufu.jbp.multitenancy;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author wang
 */
public class TenantListener {
    @PrePersist
    public void prePersist(Object entity) {
        setTenantId(entity);
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        setTenantId(entity);
    }

    private void setTenantId(Object entity) {
        if (entity.getClass().isAnnotationPresent(TenantId.class)) {
            String tenantId = TenantIdHolder.getTenantId();
            if (entity instanceof MultiTenant) {
                MultiTenant e = (MultiTenant) (entity);
                e.setTenantId(tenantId);
            }
        }
    }
}
