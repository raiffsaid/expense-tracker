package com.raibratech.expensetracker.resources;

import com.raibratech.expensetracker.models.dto.ItemDTO;
import com.raibratech.expensetracker.models.dto.UserDTO;
import com.raibratech.expensetracker.services.ItemService;
import com.raibratech.expensetracker.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    private final UserService userService;

    private final ItemService itemService;

    public UserResource(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> list = userService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        UserDTO obj = userService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO obj) {
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO obj) {
        obj = userService.update(id, obj);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/items")
    public ResponseEntity<List<ItemDTO>> getUserItems(@PathVariable String id) {
        List<ItemDTO> list = itemService.getItemsByUserId(id);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/{id}/items")
    public ResponseEntity<ItemDTO> insert(@RequestBody ItemDTO obj) {
        obj = itemService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}/items/{itemId}")
    public ResponseEntity<ItemDTO> deleteUserItem(@PathVariable String id, @PathVariable String itemId) {
        itemService.delete(itemId);
        return ResponseEntity.noContent().build();
    }
}
