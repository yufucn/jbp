package org.yufu.test.domain;

import lombok.Getter;
import lombok.Setter;
import yufu.jbp.domain.entities.auditing.FullAuditedEntity;
import yufu.jbp.multitenancy.IMultiTenant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author wang
 */
@Getter
@Setter
@Entity
public class User extends FullAuditedEntity<Long> implements IMultiTenant {

    private String name;
    private String tenantId;
}
