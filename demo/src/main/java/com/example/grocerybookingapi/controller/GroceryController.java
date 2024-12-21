package com.example.grocerybookingapi.controller;

import com.example.grocerybookingapi.entity.GroceryItem;
import com.example.grocerybookingapi.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/groceries")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping
    public GroceryItem addGrocery(@RequestBody GroceryItem groceryItem) {
        return groceryService.addGrocery(groceryItem);
    }

    @GetMapping
    public List<GroceryItem> getAllGroceries() {
        return groceryService.getAllGroceries();
    }

    @PutMapping("/{id}")
    public GroceryItem updateGrocery(@PathVariable Long id, @RequestBody GroceryItem groceryItem) {
        return groceryService.updateGrocery(id, groceryItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrocery(@PathVariable Long id) {
        groceryService.deleteGrocery(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}