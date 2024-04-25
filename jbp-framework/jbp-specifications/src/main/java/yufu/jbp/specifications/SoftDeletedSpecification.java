package yufu.jbp.specifications;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author wang
 */
public class SoftDeletedSpecification<T> implements Specification<T> {

    private static final long serialVersionUID = -940322276301888908L;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.<Integer>get("deleted"), 0);
    }
}
