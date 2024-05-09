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
public abstract class FullAuditedEntityEmbId<TKey extends Serializable>
        extends AuditedEntityEmbId<TKey> implements SoftDeletable {

    private Boolean deleted = false;
}
