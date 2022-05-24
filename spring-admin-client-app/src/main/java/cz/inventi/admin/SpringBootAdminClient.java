package cz.inventi.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBootAdminClient {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminClient.class, args);
    }

}