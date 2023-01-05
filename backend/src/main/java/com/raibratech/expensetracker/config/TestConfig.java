package com.raibratech.expensetracker.config;

import com.raibratech.expensetracker.models.embedded.Author;
import com.raibratech.expensetracker.models.entities.Item;
import com.raibratech.expensetracker.models.entities.User;
import com.raibratech.expensetracker.repositories.ItemRepository;
import com.raibratech.expensetracker.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        userRepository.deleteAll();
        itemRepository.deleteAll();

        User raiff = new User(null, "Raiff Said", "raiff.said@gmail.com");

        userRepository.save(raiff);

//        Item item1 = new Item(null, LocalDate.now(), "income", "Salário", 5000.00, new Author(raiff));
//        Item item2 = new Item(null, LocalDate.now(), "expense", "Compra 1", 150.00, new Author(raiff));
//        Item item3 = new Item(null, LocalDate.now(), "expense", "Compra 2", 2753.78, new Author(raiff));
//        Item item4 = new Item(null, LocalDate.parse("2023-02-03"), "expense", "Compra 3", 1000.00, new Author(raiff));

//        itemRepository.saveAll(Arrays.asList(item1, item2, item3, item4));
//
//        raiff.getItems().addAll(Arrays.asList(item1, item2, item3, item4));
//
//        userRepository.save(raiff);
    }
}
