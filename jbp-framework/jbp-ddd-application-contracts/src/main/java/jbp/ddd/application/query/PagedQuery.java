package jbp.ddd.application.query;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wang
 */
@Getter
@Setter
public class PagedQuery {
    private Integer pageSize;
    private Integer pageIndex;
}
