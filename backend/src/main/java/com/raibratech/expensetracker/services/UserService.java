package com.raibratech.expensetracker.services;

import com.raibratech.expensetracker.models.dto.UserDTO;
import com.raibratech.expensetracker.models.entities.User;
import com.raibratech.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        List<User> list = userRepository.findAll();
        return list.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
