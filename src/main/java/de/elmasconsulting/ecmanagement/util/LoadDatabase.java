package de.elmasconsulting.ecmanagement.util;

import de.elmasconsulting.ecmanagement.model.User;
import de.elmasconsulting.ecmanagement.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new User(3L,2,"admin","admin")));
            log.info("Preloading " + repository.save(new User(4L,3,"admin","admin")));

        };
    }
}