package jbp.ddd.application.query;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;

/**
 * @author wang
 */
@Setter
@Getter
@Slf4j
public class PagedAndSortedQuery extends PagedQuery {
    private String direction;
    private String key;

    public Sort buildSort() {
        switch (direction) {
            case "desc":
                return Sort.by(key).descending();
            case "asc":
                return Sort.by(key).ascending();
            default:
                log.warn("Invalid direction provided in PageSettings, using descending direction as default value");
                return Sort.by(key).descending();
        }
    }
}
