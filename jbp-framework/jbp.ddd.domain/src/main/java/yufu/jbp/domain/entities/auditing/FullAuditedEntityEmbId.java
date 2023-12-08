package yufu.jbp.domain.entities.auditing;

import lombok.Getter;
import lombok.Setter;
import yufu.jbp.core.ISoftDelete;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wang
 */
@MappedSuperclass
@Getter
@Setter
public abstract class FullAuditedEntityEmbId<TKey extends Serializable>
        extends AuditedEntityEmbId<TKey> implements ISoftDelete {

    private Integer deleted = 0;
}
