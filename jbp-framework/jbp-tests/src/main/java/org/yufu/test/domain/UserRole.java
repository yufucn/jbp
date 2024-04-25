package org.yufu.test.domain;

import lombok.Getter;
import lombok.Setter;
import yufu.jbp.domain.entities.auditing.FullAuditedEntity;
import yufu.jbp.domain.entities.auditing.FullAuditedEntityEmbId;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author wang
 */
@Entity
@Getter
@Setter
public class UserRole extends FullAuditedEntityEmbId<UserRoleId> {
    private String dep;
}
