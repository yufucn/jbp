package yufu.jbp.data.domain.support;

import yufu.jbp.data.domain.SoftDeletable;

import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 * @author wang
 */
public class SoftDeleteEntityListener {
    @PreRemove
    public void preRemove(Object entity) {
        if (entity instanceof SoftDeletable) {
            SoftDeletable softDeletable = (SoftDeletable) entity;
            softDeletable.setDeleted(true);
        }
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        if (entity instanceof SoftDeletable) {
            SoftDeletable softDeletable = (SoftDeletable) entity;
            if (softDeletable.getDeleted()) {
                throw new RuntimeException("Soft deleted entity should not be updated.");
            }
        }
    }
}
