package org.yufu.test.domain;

import lombok.Getter;
import lombok.Setter;
import yufu.jbp.domain.entities.auditing.FullAuditedEntity;
import yufu.jbp.multitenancy.MultiTenant;
import yufu.jbp.multitenancy.TenantId;
import yufu.jbp.multitenancy.TenantListener;

import javax.persistence.*;

/**
 * @author wang
 */
@Getter
@Setter
@Entity
@EntityListeners(TenantListener.class)
public class User extends FullAuditedEntity<Long> implements MultiTenant {

    private String name;
    @TenantId
    private String tenantId;

}
