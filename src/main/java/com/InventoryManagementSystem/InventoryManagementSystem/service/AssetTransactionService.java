package com.InventoryManagementSystem.InventoryManagementSystem.service;

import com.InventoryManagementSystem.InventoryManagementSystem.model.*;
import com.InventoryManagementSystem.InventoryManagementSystem.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AssetTransactionService {

    private final AssetTransactionRepository txRepo;
    private final AssetRepository assetRepo;
    private final UserRepository userRepo;

    public AssetTransactionService(AssetTransactionRepository txRepo,
                                   AssetRepository assetRepo,
                                   UserRepository userRepo) {
        this.txRepo = txRepo;
        this.assetRepo = assetRepo;
        this.userRepo = userRepo;
    }

    // ISSUE ASSET
    public void issueAsset(Long assetId, Long userId) {

        Asset asset = assetRepo.findById(assetId).orElse(null);
        User user = userRepo.findById(userId).orElse(null);

        if (asset == null || user == null) return;

        // Update asset
        asset.setStatus("Issued");
        asset.setAssignedTo(user.getName());
        assetRepo.save(asset);

        // Save transaction
        AssetTransaction tx = new AssetTransaction();
        tx.setAsset(asset);
        tx.setUser(user);
        tx.setAction("ISSUE");
        tx.setDate(LocalDate.now());

        txRepo.save(tx);
    }

    // RETURN ASSET
    public void returnAsset(Long assetId) {

        Asset asset = assetRepo.findById(assetId).orElse(null);

        if (asset == null) return;

        // Save transaction
        AssetTransaction tx = new AssetTransaction();
        tx.setAsset(asset);
        tx.setAction("RETURN");
        tx.setDate(LocalDate.now());

        txRepo.save(tx);

        // Reset asset
        asset.setStatus("Available");
        asset.setAssignedTo(null);
        assetRepo.save(asset);
    }

    // GET HISTORY
    public List<AssetTransaction> getAllTransactions() {
        return txRepo.findAll();
    }
}