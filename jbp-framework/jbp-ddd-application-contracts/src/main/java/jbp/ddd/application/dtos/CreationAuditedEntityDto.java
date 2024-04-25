package jbp.ddd.application.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wang
 */
@Getter
@Setter
public abstract class CreationAuditedEntityDto<TKey> extends EntityDto<TKey> {
    private String createBy;
    private Date createdDate;
}
