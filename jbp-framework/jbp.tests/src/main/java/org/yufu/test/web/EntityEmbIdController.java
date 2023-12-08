package org.yufu.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yufu.test.domain.User;
import org.yufu.test.domain.UserRole;
import org.yufu.test.domain.UserRoleId;
import org.yufu.test.domain.UserRoleRepository;

/**
 * @author wang
 */
@RestController
public class EntityEmbIdController {
    private final UserRoleRepository userRoleRepository;

    public EntityEmbIdController(UserRoleRepository userRepository) {
        this.userRoleRepository = userRepository;
    }

    @GetMapping("/user-role/add")
    public String home() {
        UserRole user = new UserRole();
        user.setDep("wang");
        UserRoleId id = new UserRoleId();
        id.setRoleId(1L);
        id.setUserId(2L);
        user.setId(id);
        userRoleRepository.save(user);
        return "ok";
    }

    @GetMapping("/user-role/{roleId}/{userId}")
    public UserRole get(
            @PathVariable Long roleId, @PathVariable Long userId
    ) {
        UserRoleId id = new UserRoleId();
        id.setRoleId(roleId);
        id.setUserId(userId);
        return userRoleRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{roleId}/{userId}")
    public Boolean delete(
            @PathVariable Long roleId, @PathVariable Long userId
    ) {
        UserRoleId id = new UserRoleId();
        id.setRoleId(roleId);
        id.setUserId(userId);
        userRoleRepository.deleteById(id);
        return true;
    }
}
