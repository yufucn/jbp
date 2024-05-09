package io.github.yufucn.jbp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author wang
 */
@NoRepositoryBean
public interface IRepository<TEntity, TKey>
        extends JpaRepository<TEntity, TKey>, JpaSpecificationExecutor<TEntity> {
}
