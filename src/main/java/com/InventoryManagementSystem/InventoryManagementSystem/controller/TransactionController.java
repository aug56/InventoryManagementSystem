package com.InventoryManagementSystem.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.InventoryManagementSystem.service.AssetService;
import com.InventoryManagementSystem.InventoryManagementSystem.service.UserService;
import com.InventoryManagementSystem.InventoryManagementSystem.service.AssetTransactionService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final AssetService assetService;
    private final UserService userService;
    private final AssetTransactionService txService;

    public TransactionController(AssetService assetService,
                                 UserService userService,
                                 AssetTransactionService txService) {
        this.assetService = assetService;
        this.userService = userService;
        this.txService = txService;
    }

    // Show Issue Page
    @GetMapping("/issue")
    public String showIssuePage(Model model) {

        model.addAttribute("assets", assetService.getAllAssets()); // ✅ FIXED
        model.addAttribute("users", userService.getAllUsers());

        return "issue-asset";
    }

    // Handle Issue
    @PostMapping("/issue")
    public String issueAsset(@RequestParam Long assetId,
                             @RequestParam Long userId) {
        txService.issueAsset(assetId, userId);
        return "redirect:/";
    }

    // Show Return Page
    @GetMapping("/return")
    public String showReturnPage(Model model) {
        model.addAttribute("assets", assetService.getAllAssets());
        return "return-asset";
    }

    // Handle Return
    @PostMapping("/return")
    public String returnAsset(@RequestParam Long assetId) {
        txService.returnAsset(assetId);
        return "redirect:/";
    }

    // View History
    @GetMapping("/history")
    public String viewHistory(Model model) {
        model.addAttribute("transactions", txService.getAllTransactions());
        return "history";
    }
}