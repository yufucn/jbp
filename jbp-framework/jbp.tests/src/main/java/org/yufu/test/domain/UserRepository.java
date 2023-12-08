package org.yufu.test.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wang
 */
@Repository
@Scope("singleton")
public interface UserRepository extends JpaRepository<User, Long> {
}
