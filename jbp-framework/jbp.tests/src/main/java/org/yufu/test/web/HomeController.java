package org.yufu.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yufu.test.domain.User;
import org.yufu.test.domain.UserRepository;
import yufu.jbp.core.ISoftDelete;
import yufu.jbp.data.IDataFilter;

import java.io.Closeable;

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
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    public Boolean delete(
            @PathVariable Long id
    ) {
        userRepository.deleteById(id);
        return true;
    }
}
