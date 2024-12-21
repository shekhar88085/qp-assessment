package com.example.grocerybookingapi;

import com.example.grocerybookingapi.entity.GroceryItem;
import com.example.grocerybookingapi.repository.GroceryItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GroceryItemRepositoryTest {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    private GroceryItem groceryItem;

    @BeforeEach
    public void setUp() {
        groceryItem = new GroceryItem();
        groceryItem.setName("Banana");
        groceryItem.setPrice(1.2);
        groceryItem.setInventory(50);
    }

    @Test
    public void testSaveAndFind() {
        groceryItemRepository.save(groceryItem);

        GroceryItem foundItem = groceryItemRepository.findById(groceryItem.getId()).orElse(null);
        assertTrue(foundItem != null && foundItem.getName().equals("Banana"));
    }
}