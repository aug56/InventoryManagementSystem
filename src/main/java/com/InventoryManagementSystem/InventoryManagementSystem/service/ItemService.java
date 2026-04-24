package com.InventoryManagementSystem.InventoryManagementSystem.service;

import com.InventoryManagementSystem.InventoryManagementSystem.model.Item;
import com.InventoryManagementSystem.InventoryManagementSystem.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repo;

    public ItemService(ItemRepository repo) {
        this.repo = repo;
    }

    public List<Item> getAllItems() {
        return repo.findAll();
    }

    public Item getItemById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void saveItem(Item item) {
        repo.save(item);
    }

    public void deleteItem(Long id) {
        repo.deleteById(id);
    }
}