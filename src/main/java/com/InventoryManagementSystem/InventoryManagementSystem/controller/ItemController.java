package com.InventoryManagementSystem.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.InventoryManagementSystem.model.Item;
import com.InventoryManagementSystem.InventoryManagementSystem.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    // 📌 LIST ITEMS
    @GetMapping
    public String viewItems(Model model) {
        model.addAttribute("items", service.getAllItems());
        return "items";
    }

    // 📌 SHOW ADD FORM
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("item", new Item());
        return "item-form";
    }

    // 📌 SAVE ITEM
    @PostMapping("/save")
    public String saveItem(@ModelAttribute Item item) {
        service.saveItem(item);
        return "redirect:/items";
    }

    // 📌 EDIT ITEM
    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        model.addAttribute("item", service.getItemById(id));
        return "item-edit";
    }

    // 📌 UPDATE ITEM
    @PostMapping("/update")
    public String updateItem(@ModelAttribute Item item) {
        service.saveItem(item);
        return "redirect:/items";
    }

    // 📌 DELETE ITEM
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return "redirect:/items";
    }
}