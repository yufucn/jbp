package org.yufu.test.domain;

import lombok.Getter;
import lombok.Setter;
import yufu.jbp.data.annotation.SoftDelete;
import yufu.jbp.domain.entities.auditing.AuditedEntity;
import yufu.jbp.domain.entities.auditing.FullAuditedEntity;
import yufu.jbp.multitenancy.IMultiTenant;

import javax.persistence.*;

/**
 * @author wang
 */
@Getter
@Setter
@Entity
public class User extends AuditedEntity<Long> implements IMultiTenant {

    private String name;
    private String tenantId;
    @SoftDelete
    private boolean deleted;

    @PreRemove
    private void preRemove() {
        // 在删除操作之前触发，你可以在这里实现软删除的逻辑
        this.deleted = true;
        System.out.println("Soft delete logic executed.");
    }
}
