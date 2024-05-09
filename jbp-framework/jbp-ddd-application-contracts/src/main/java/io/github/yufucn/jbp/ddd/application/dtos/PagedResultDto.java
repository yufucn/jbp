package io.github.yufucn.jbp.ddd.application.dtos;

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
