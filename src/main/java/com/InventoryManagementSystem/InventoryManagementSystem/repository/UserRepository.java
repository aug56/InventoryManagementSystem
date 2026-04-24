package com.InventoryManagementSystem.InventoryManagementSystem.repository;

import com.InventoryManagementSystem.InventoryManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}