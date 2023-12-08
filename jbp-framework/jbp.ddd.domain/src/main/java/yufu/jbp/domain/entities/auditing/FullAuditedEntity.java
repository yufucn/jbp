package yufu.jbp.domain.entities.auditing;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import yufu.jbp.core.ISoftDelete;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wang
 */
@MappedSuperclass
@Getter
@Setter
public abstract class FullAuditedEntity<TKey extends Serializable>
        extends AuditedEntity<TKey> implements ISoftDelete {

    private Integer deleted = 0;
}
