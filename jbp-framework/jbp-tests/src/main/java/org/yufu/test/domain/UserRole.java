package org.yufu.test.domain;

import lombok.Getter;
import lombok.Setter;
import io.github.yufucn.jbp.domain.entities.auditing.FullAuditedEntityEmbId;

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
