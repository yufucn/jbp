package org.yufu.test.domain;

import lombok.Getter;
import lombok.Setter;
import yufu.jbp.domain.entities.auditing.FullAuditedEntity;
import yufu.jbp.multitenancy.MultiTenant;

import javax.persistence.*;

/**
 * @author wang
 */
@Getter
@Setter
@Entity
public class User extends FullAuditedEntity<Long> implements MultiTenant {

    private String name;
    private String tenantId;

}
