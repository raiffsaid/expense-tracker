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

        User lorraine = new User(null, "Lorraine Coêlho", "lorrainefcoelho@gmail.com");
        User raiff = new User(null, "Raiff Said", "raiff.said@gmail.com");

        Item item1 = new Item(null, LocalDate.parse("2022-12-07"), "income", "Salário Lorraine", 3500.00, new Author(lorraine));
        Item item2 = new Item(null, LocalDate.parse("2022-12-20"), "expense", "Compra Lorraine", 4000.00, new Author(lorraine));

        Item item3 = new Item(null, LocalDate.parse("2022-12-01"), "income", "Salário", 5000.00, new Author(raiff));
        Item item4 = new Item(null, LocalDate.parse("2022-12-05"), "expense", "Compra 1", 150.00, new Author(raiff));
        Item item5 = new Item(null, LocalDate.parse("2022-12-12"), "expense", "Compra 2", 2753.78, new Author(raiff));

        userRepository.saveAll(Arrays.asList(lorraine, raiff));
        itemRepository.saveAll(Arrays.asList(item1, item2, item3, item4, item5));

        lorraine.getItems().addAll(Arrays.asList(item1, item2));
        raiff.getItems().addAll(Arrays.asList(item3, item4, item5));

        userRepository.saveAll(Arrays.asList(lorraine, raiff));
    }
}
