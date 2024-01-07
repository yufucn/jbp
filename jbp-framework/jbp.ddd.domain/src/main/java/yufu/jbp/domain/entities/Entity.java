package yufu.jbp.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wang
 */
@MappedSuperclass
@Getter
@Setter
public abstract class Entity<TKey extends Serializable> implements Serializable, IEntity<TKey> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private TKey id;
}
