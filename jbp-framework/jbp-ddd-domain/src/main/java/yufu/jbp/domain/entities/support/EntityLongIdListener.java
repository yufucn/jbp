package yufu.jbp.domain.entities.support;

import yufu.jbp.domain.entities.Entity;
import yufu.jbp.domain.entities.IEntity;
import yufu.jbp.guids.SnowflakeIdGenerator;
import yufu.jbp.multitenancy.MultiTenant;
import yufu.jbp.multitenancy.TenantId;

import javax.persistence.PrePersist;
import java.lang.annotation.Annotation;

/**
 * @author wang
 */
public class EntityLongIdListener {

    @PrePersist
    public void prePersist(Entity<Long> entity) {
        if (entity instanceof Entity) {
//            Long id = SnowflakeIdGenerator.generateId();
//            entity.setId(id);
        }

    }
}
