package yufu.jbp.domain.entities;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author wang
 */
public interface IEntity<TKey extends Serializable> {
    TKey getId();

    void setId(TKey id);
}
