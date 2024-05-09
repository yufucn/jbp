package io.github.yufucn.jbp.domain.entities.support;

import io.github.yufucn.jbp.domain.entities.Entity;

import javax.persistence.PrePersist;

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
