package jbp.ddd.application.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wang
 */
@Setter
@Getter
@ToString
public class PagedResultDto<T> extends ListResultDto<T> {
    private Long total;
}
