package jbp.ddd.application.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wang
 */
@Getter
@Setter
public abstract class FullAuditedEntityDto<TKey> extends AuditedEntityDto<TKey> {
    private Integer deleted;
}
