package io.github.yufucn.jbp.domain.entities.auditing;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import io.github.yufucn.jbp.domain.entities.Entity;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wang
 */
@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class CreationAuditedEntity<TKey extends Serializable>
        extends Entity<TKey> {

    @CreatedBy
    private String createBy;

    @CreatedDate
    private Date createdDate;
}
