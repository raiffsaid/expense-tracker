package com.raibratech.expensetracker.services;

import com.raibratech.expensetracker.models.dto.UserDTO;
import com.raibratech.expensetracker.models.entities.User;
import com.raibratech.expensetracker.repositories.UserRepository;
import com.raibratech.expensetracker.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        List<User> list = userRepository.findAll();
        return list.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO findById(String id) {
        User entity = getEntityById(id);
        return new UserDTO(entity);
    }

    public UserDTO insert(UserDTO dto) {
        User entity = new User();
        copyUserDtoToEntity(dto, entity);
        entity = userRepository.insert(entity);
        return new UserDTO(entity);
    }

    public UserDTO update(String id, UserDTO dto) {
        User entity = getEntityById(id);
        copyUserDtoToEntity(dto, entity);
        entity = userRepository.save(entity);
        return new UserDTO(entity);
    }

    public void delete(String id) {
        getEntityById(id);
        userRepository.deleteById(id);
    }

    private void copyUserDtoToEntity(UserDTO dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }

    private User getEntityById(String id) {
        Optional<User> result = userRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    }
}
