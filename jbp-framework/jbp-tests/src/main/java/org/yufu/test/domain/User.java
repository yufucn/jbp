package org.yufu.test.domain;

import lombok.Getter;
import lombok.Setter;
import io.github.yufucn.jbp.domain.entities.auditing.FullAuditedEntity;
import io.github.yufucn.jbp.domain.entities.support.EntityLongIdListener;
import io.github.yufucn.jbp.multitenancy.MultiTenant;
import io.github.yufucn.jbp.multitenancy.TenantId;
import io.github.yufucn.jbp.multitenancy.TenantListener;

import javax.persistence.*;

/**
 * @author wang
 */
@Getter
@Setter
@Entity
@EntityListeners({TenantListener.class, EntityLongIdListener.class})
public class User extends FullAuditedEntity<Long> implements MultiTenant {

    private String name;
    @TenantId
    private String tenantId;

}
