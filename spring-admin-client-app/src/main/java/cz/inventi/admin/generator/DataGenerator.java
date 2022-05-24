package cz.inventi.admin.generator;

import com.github.javafaker.Faker;
import cz.inventi.admin.db.model.AddressEntity;
import cz.inventi.admin.db.model.UserEntity;
import cz.inventi.admin.db.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Slf4j
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() != 0L) {
                log.info("Using existing database");
                return;
            }

            log.info("Generating demo data");

            Faker faker = new Faker();

            userRepository.saveAll(IntStream.range(0, 51)
                    .mapToObj(x -> new UserEntity(
                            faker.name().firstName(),
                            faker.name().lastName(),
                            faker.internet().emailAddress(),
                            new Date(faker.date().birthday().getTime()).toLocalDate(),
                            new AddressEntity(
                                    faker.address().streetAddress(),
                                    faker.address().secondaryAddress(),
                                    faker.address().city(),
                                    faker.address().zipCode(),
                                    faker.address().country()))
                    )
                    .collect(Collectors.toList()));
        };
    }
}
