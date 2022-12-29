package com.raibratech.expensetracker.repositories;

import com.raibratech.expensetracker.models.entities.Item;
import com.raibratech.expensetracker.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
