package yufu.jbp.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wang
 */
@Getter
@Setter
@Slf4j
@MappedSuperclass
public abstract class AggregateRoot<TKey extends Serializable>
        extends AbstractAggregateRoot implements IEntity<TKey> {
    @Id
    private TKey id;
}
