package com.InventoryManagementSystem.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.InventoryManagementSystem.model.Asset;
import com.InventoryManagementSystem.InventoryManagementSystem.service.AssetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AssetController {

    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("assets", service.getAllAssets());
        return "index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("asset", new Asset());
        return "form";
    }

    @PostMapping("/save")
    public String saveAsset(@ModelAttribute Asset asset) {
        service.saveAsset(asset);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteAsset(id);
        return "redirect:/";
    }
    
}