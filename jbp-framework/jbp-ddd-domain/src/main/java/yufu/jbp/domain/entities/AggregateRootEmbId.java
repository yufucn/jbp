package yufu.jbp.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wang
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AggregateRootEmbId<TKey extends Serializable>
        extends AbstractAggregateRoot implements IEntity<TKey> {

    @EmbeddedId
    private TKey id;
}
