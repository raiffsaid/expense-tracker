package com.raibratech.expensetracker.services;

import com.raibratech.expensetracker.models.dto.ItemDTO;
import com.raibratech.expensetracker.models.entities.Item;
import com.raibratech.expensetracker.models.entities.User;
import com.raibratech.expensetracker.repositories.ItemRepository;
import com.raibratech.expensetracker.repositories.UserRepository;
import com.raibratech.expensetracker.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public ItemService(ItemRepository itemRepository,
                       UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public List<ItemDTO> getItemsByUserId(String id) {
        List<Item> items = itemRepository.findItemsByUserId(id);
        return items.stream().map(ItemDTO::new).collect(Collectors.toList());
    }

    public ItemDTO insert(ItemDTO dto) {
        Item entity = new Item();
        copyItemDtoToEntity(dto, entity);
        entity = itemRepository.insert(entity);
        User user = userRepository.findById(entity.getUserId()).get();
        user.getItems().add(entity);
        userRepository.save(user);
        return new ItemDTO(entity);
    }

    public void delete(String id) {
        itemRepository.deleteById(id);
    }

    private void copyItemDtoToEntity(ItemDTO dto, Item entity) {
        entity.setDate(dto.getDate());
        entity.setCategory(dto.getCategory());
        entity.setTitle(dto.getTitle());
        entity.setValue(dto.getValue());
        entity.setUserId(dto.getUserId());
    }
}
