package org.yufu.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yufu.test.domain.User;
import org.yufu.test.domain.UserRepository;
import yufu.jbp.data.DataFilterScope;
import yufu.jbp.data.domain.SoftDeletable;
import yufu.jbp.guids.SnowflakeIdGenerator;
import yufu.jbp.multitenancy.MultiTenant;

import javax.sql.DataSource;

/**
 * @author wang
 */
@RestController
public class HomeController {

    private final UserRepository userRepository;

    @Autowired
    private DataSource dataSource;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add")
    public String home() {
        User user = new User();
        user.setName("wang");
        userRepository.save(user);
        return "ok";
    }

    @GetMapping("/{id}")
    public User get(
            @PathVariable Long id
    ) {
//        User u1 ;
//        try (DataFilterScope scope = new DataFilterScope(SoftDeletable.class)) {
//            u1 = userRepository.findById(id).orElse(null);
//        }
        Long id1 = SnowflakeIdGenerator.generateId();
        User u1 = userRepository.findById(id).orElse(null);
        return u1;
    }

    @GetMapping("/delete/{id}")
    public Boolean delete(
            @PathVariable Long id
    ) {
        userRepository.deleteById(id);
        return true;
    }
}
