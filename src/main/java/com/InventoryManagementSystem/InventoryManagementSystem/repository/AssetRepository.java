package com.InventoryManagementSystem.InventoryManagementSystem.repository;

import com.InventoryManagementSystem.InventoryManagementSystem.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}