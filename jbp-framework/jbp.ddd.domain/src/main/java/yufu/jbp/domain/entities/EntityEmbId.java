package yufu.jbp.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author wang
 */
@MappedSuperclass
@Getter
@Setter
public abstract class EntityEmbId<TKey extends Serializable> implements Serializable {
    @EmbeddedId
    public TKey Id;
}
