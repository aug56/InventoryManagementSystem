package com.InventoryManagementSystem.InventoryManagementSystem.repository;

import com.InventoryManagementSystem.InventoryManagementSystem.model.AssetTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetTransactionRepository extends JpaRepository<AssetTransaction, Long> {
}