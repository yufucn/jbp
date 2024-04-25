package yufu.jbp.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author wang
 */
public class MultiTenancySpecification<T> implements Specification<T> {

    private static final long serialVersionUID = -940322276301888908L;
    private final transient String tenantId;

    public MultiTenancySpecification(String tenancyId) {
        this.tenantId = tenancyId;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.<Integer>get("tenantId"), tenantId);
    }
}
