package yufu.jbp.domain.entities.auditing;

import lombok.Getter;
import lombok.Setter;
import yufu.jbp.data.annotation.SoftDelete;
import yufu.jbp.data.domain.SoftDeletable;
import yufu.jbp.data.domain.support.SoftDeleteEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wang
 */
@MappedSuperclass
@Getter
@Setter
@EntityListeners(SoftDeleteEntityListener.class)
public abstract class FullAuditedAggregateRoot<TKey extends Serializable>
        extends AuditedAggregateRoot<TKey> implements SoftDeletable {

    @SoftDelete
    private Boolean deleted;
}
