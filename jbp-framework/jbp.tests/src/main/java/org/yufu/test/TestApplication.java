package org.yufu.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import yufu.jbp.domain.repositories.JbpRepository;

/**
 * @author wang
 */
@SpringBootApplication(scanBasePackages = {"org.yufu", "jbp.springframework"})
@ComponentScan(basePackages = {"org.yufu", "jbp.springframework"}) // 请替换为你的实际包名
@EnableJpaRepositories(repositoryBaseClass = JbpRepository.class)
@EnableTransactionManagement
@EnableJpaAuditing
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
