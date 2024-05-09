package io.github.yufucn.jbp.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wang
 */
@MappedSuperclass
@Getter
@Setter
public abstract class Entity<TKey extends Serializable> implements Serializable, IEntity<TKey> {
    @Id
    private TKey id;
}
