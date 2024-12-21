package com.example.grocerybookingapi.service;

import com.example.grocerybookingapi.entity.GroceryItem;
import com.example.grocerybookingapi.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public GroceryItem addGrocery(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public List<GroceryItem> getAllGroceries() {
        return groceryItemRepository.findAll();
    }

    public Optional<GroceryItem> getGroceryById(Long id) {
        return groceryItemRepository.findById(id);
    }

    public void deleteGrocery(Long id) {
        groceryItemRepository.deleteById(id);
    }

    public GroceryItem updateGrocery(Long id, GroceryItem updatedItem) {
        GroceryItem existingItem = groceryItemRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Grocery not found"));
    
        // Update fields
        existingItem.setName(updatedItem.getName());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setInventory(updatedItem.getInventory());
    
        // Save updated item
        return groceryItemRepository.save(existingItem);
    }
    
}