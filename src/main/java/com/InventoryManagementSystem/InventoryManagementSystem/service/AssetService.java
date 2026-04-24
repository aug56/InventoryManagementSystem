package com.InventoryManagementSystem.InventoryManagementSystem.service;

import com.InventoryManagementSystem.InventoryManagementSystem.model.Asset;
import com.InventoryManagementSystem.InventoryManagementSystem.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    private final AssetRepository repo;

    public AssetService(AssetRepository repo) {
        this.repo = repo;
    }

    public Asset saveAsset(Asset asset) {
        return repo.save(asset);
    }

    public List<Asset> getAllAssets() {
        return repo.findAll();
    }

    public Asset getAssetById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteAsset(Long id) {
        repo.deleteById(id);
    }
}