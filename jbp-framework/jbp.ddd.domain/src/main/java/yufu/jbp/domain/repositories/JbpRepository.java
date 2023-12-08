package yufu.jbp.domain.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import yufu.jbp.core.ISoftDelete;
import yufu.jbp.domain.entities.auditing.FullAuditedEntity;
import yufu.jbp.multitenancy.IMultiTenant;
import yufu.jbp.specifications.ByIdSpecification;
import yufu.jbp.specifications.MultiTenancySpecification;
import yufu.jbp.specifications.SoftDeletedSpecification;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Predicate;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author wang
 */
public class JbpRepository<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> {

    private final EntityManager entityManager;
    private final JpaEntityInformation<T, ?> entityInformation;

    public JbpRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
    }

    @Override
    public Optional<T> findById(ID id) {
        return super.findOne(Specification.where(new ByIdSpecification<>(entityInformation, id)));
    }

    @Override
    public void delete(T entity) {
        if (entity instanceof ISoftDelete) {
            ((ISoftDelete) entity).setDeleted(1);
            super.save(entity);
        } else {
            super.delete(entity);
        }
    }

    @Override
    protected <S extends T> TypedQuery<Long> getCountQuery(Specification<S> spec, Class<S> domainClass) {
        if (ISoftDelete.class.isAssignableFrom(domainClass)) {
            if (spec == null) {
                spec = softDeleted();
            } else {
                spec = spec.and(softDeleted());
            }
        }


        return super.getCountQuery(spec, domainClass);
    }

    @Override
    protected <S extends T> TypedQuery<S> getQuery(Specification<S> spec, Class<S> domainClass, Sort sort) {
        if (ISoftDelete.class.isAssignableFrom(domainClass)) {
            if (spec == null) {
                spec = softDeleted();
            } else {
                spec = spec.and(softDeleted());
            }
        }
        if (IMultiTenant.class.isAssignableFrom(domainClass)) {
            spec = spec.and(multiTenant("yufu"));
        }
        return super.getQuery(spec, domainClass, sort);
    }

    private <T> Specification<T> softDeleted() {
        return Specification.where(new SoftDeletedSpecification<>());
    }

    private <T> Specification<T> multiTenant(String tenantId) {

        return Specification.where(new MultiTenancySpecification<T>(tenantId));
    }

}
