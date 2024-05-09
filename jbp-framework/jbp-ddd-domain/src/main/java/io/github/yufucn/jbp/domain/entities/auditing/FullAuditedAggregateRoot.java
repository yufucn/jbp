package io.github.yufucn.jbp.domain.entities.auditing;

import lombok.Getter;
import lombok.Setter;
import io.github.yufucn.jbp.data.domain.SoftDeletable;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wang
 */
@MappedSuperclass
@Getter
@Setter
public abstract class FullAuditedAggregateRoot<TKey extends Serializable>
        extends AuditedAggregateRoot<TKey> implements SoftDeletable {

    private Boolean deleted = false;
}
