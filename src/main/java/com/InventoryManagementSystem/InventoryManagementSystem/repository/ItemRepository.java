package com.InventoryManagementSystem.InventoryManagementSystem.repository;

import com.InventoryManagementSystem.InventoryManagementSystem.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}