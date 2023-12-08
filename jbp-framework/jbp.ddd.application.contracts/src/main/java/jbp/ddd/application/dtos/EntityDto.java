package jbp.ddd.application.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wang
 */
@Getter
@Setter
public abstract class EntityDto<TKey> implements IEntityDto<TKey> {
    private TKey id;
}
