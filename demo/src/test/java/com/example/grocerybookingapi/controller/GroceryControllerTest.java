package com.example.grocerybookingapi.controller;

import com.example.grocerybookingapi.entity.GroceryItem;
import com.example.grocerybookingapi.repository.GroceryItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GroceryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private GroceryItem groceryItem;

    @BeforeEach
    public void setUp() {
        groceryItem = new GroceryItem();
        groceryItem.setName("Apple");
        groceryItem.setPrice(2.5);
        groceryItem.setInventory(100);
    }

    @Test
    public void testAddGrocery() throws Exception {
        mockMvc.perform(post("/admin/groceries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(groceryItem)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Apple"))
                .andExpect(jsonPath("$.price").value(2.5))
                .andExpect(jsonPath("$.inventory").value(100));
    }

    @Test
    public void testGetAllGroceries() throws Exception {
        groceryItemRepository.save(groceryItem);

        mockMvc.perform(get("/admin/groceries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Apple"));
    }

    @Test
    public void testUpdateGrocery() throws Exception {
        GroceryItem savedGrocery = groceryItemRepository.save(groceryItem);
        savedGrocery.setPrice(3.0);

        mockMvc.perform(put("/admin/groceries/{id}", savedGrocery.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(savedGrocery)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(3.0));
    }

    @Test
    public void testDeleteGrocery() throws Exception {
        GroceryItem savedGrocery = groceryItemRepository.save(groceryItem);

        mockMvc.perform(delete("/admin/groceries/{id}", savedGrocery.getId()))
                .andExpect(status().isNoContent()); // Should expect 204 No Content
    }
}