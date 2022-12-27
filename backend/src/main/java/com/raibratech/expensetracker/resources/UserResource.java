package com.raibratech.expensetracker.resources;

import com.raibratech.expensetracker.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = new ArrayList<>();
        list.add(new User(1L, "Lorraine", "Coêlho", "lorrainefcoelho@gmail.com", "123456"));
        return ResponseEntity.ok(list);
    }
}
