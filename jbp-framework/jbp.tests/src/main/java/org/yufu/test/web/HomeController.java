package org.yufu.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yufu.test.domain.User;
import org.yufu.test.domain.UserRepository;
import yufu.jbp.data.DataFilterScope;
import yufu.jbp.data.domain.SoftDeletable;
import yufu.jbp.multitenancy.MultiTenant;

/**
 * @author wang
 */
@RestController
public class HomeController {

    private final UserRepository userRepository;

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
        User u2;
        try (DataFilterScope scope = new DataFilterScope(MultiTenant.class, SoftDeletable.class)) {
            u2 = userRepository.findById(id).orElse(null);
        }
        User u1 = userRepository.findById(id).orElse(null);
        System.out.println(u1);
        return u2;
    }

    @GetMapping("/delete/{id}")
    public Boolean delete(
            @PathVariable Long id
    ) {
        userRepository.deleteById(id);
        return true;
    }
}
