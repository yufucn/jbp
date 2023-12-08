package jbp.ddd.application.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wang
 */
@Getter
@Setter
public abstract class AuditedEntityDto<TKey> extends CreationAuditedEntityDto<TKey> {
    private Date lastModifiedDate;

    private String lastModifiedBy;

}
