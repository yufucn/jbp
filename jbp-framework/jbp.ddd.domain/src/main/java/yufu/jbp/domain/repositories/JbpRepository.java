package yufu.jbp.domain.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import yufu.jbp.data.DataFilter;
import yufu.jbp.data.domain.SoftDeletable;
import yufu.jbp.multitenancy.MultiTenant;
import yufu.jbp.specifications.ByIdSpecification;
import yufu.jbp.specifications.MultiTenancySpecification;
import yufu.jbp.specifications.SoftDeletedSpecification;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
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
        if (entity instanceof SoftDeletable) {
            ((SoftDeletable) entity).setDeleted(true);
            super.save(entity);
        } else {
            super.delete(entity);
        }
    }

    @Override
    protected <S extends T> TypedQuery<Long> getCountQuery(Specification<S> spec, Class<S> domainClass) {
        spec = createFilterSpecification(spec, domainClass);
        return super.getCountQuery(spec, domainClass);
    }

    @Override
    protected <S extends T> TypedQuery<S> getQuery(Specification<S> spec, Class<S> domainClass, Sort sort) {
        spec = createFilterSpecification(spec, domainClass);
        return super.getQuery(spec, domainClass, sort);
    }

    private <S extends T> Specification<S> createFilterSpecification(Specification<S> spec, Class<S> domainClass) {
        if (SoftDeletable.class.isAssignableFrom(domainClass) && DataFilter.isEnabled(SoftDeletable.class)) {
            if (spec == null) {
                spec = softDeleted();
            } else {
                spec = spec.and(softDeleted());
            }
        }
        if (MultiTenant.class.isAssignableFrom(domainClass) && DataFilter.isEnabled(MultiTenant.class)) {
            spec = spec.and(multiTenant("yufu"));
        }
        return spec;
    }

    private <T> Specification<T> softDeleted() {
        return Specification.where(new SoftDeletedSpecification<>());
    }

    private <T> Specification<T> multiTenant(String tenantId) {

        return Specification.where(new MultiTenancySpecification<T>(tenantId));
    }
}
