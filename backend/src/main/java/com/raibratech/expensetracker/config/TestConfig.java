package com.raibratech.expensetracker.config;

import com.raibratech.expensetracker.models.entities.User;
import com.raibratech.expensetracker.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.deleteAll();

        User lorraine = new User(null, "Lorraine Coêlho", "lorrainefcoelho@gmail.com");
        User raiff = new User(null, "Raiff Said", "raiff.said@gmail.com");

        userRepository.saveAll(Arrays.asList(lorraine, raiff));
    }
}
