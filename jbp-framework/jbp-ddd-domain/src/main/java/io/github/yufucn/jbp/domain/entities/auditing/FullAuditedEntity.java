package io.github.yufucn.jbp.domain.entities.auditing;

import io.github.yufucn.jbp.data.domain.SoftDeletable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wang
 */
@MappedSuperclass
@Getter
@Setter
public abstract class FullAuditedEntity<TKey extends Serializable>
        extends AuditedEntity<TKey> implements SoftDeletable {

    private Boolean deleted = false;
}
