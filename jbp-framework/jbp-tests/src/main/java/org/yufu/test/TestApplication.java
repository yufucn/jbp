package org.yufu.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import io.github.yufucn.jbp.domain.repositories.JbpRepository;


/**
 * @author wang
 */
@SpringBootApplication(scanBasePackages = {
        "org.yufu",
        "io.github.yufucn"
        })
@EnableJpaRepositories(
//        repositoryBaseClass = JbpRepository.class
)
@EnableJpaAuditing
public class TestApplication {
    public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);
    }
}
