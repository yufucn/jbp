package yufu.jbp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wang
 */
public interface IRepository<TEntity, TKey>
        extends JpaRepository<TEntity, TKey>, JpaSpecificationExecutor<TEntity> {
}
