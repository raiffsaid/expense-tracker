package com.raibratech.expensetracker.repositories;

import com.raibratech.expensetracker.models.entities.Item;
import com.raibratech.expensetracker.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findItemsByUserIdOrderByDateAsc(String userId);
}
