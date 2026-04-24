package com.InventoryManagementSystem.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.InventoryManagementSystem.model.User;
import com.InventoryManagementSystem.InventoryManagementSystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // View all users
    @GetMapping("/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "users";
    }

    // Show form
    @GetMapping("/users/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    // Save user
    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute User user) {
        service.saveUser(user);
        return "redirect:/users";
    }

    // Delete user
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "redirect:/users";
        
    }
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "user-edit";
    }
    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute User user) {
        service.saveUser(user);
        return "redirect:/users";
    }
}