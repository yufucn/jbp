package org.yufu.test.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wang
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}
