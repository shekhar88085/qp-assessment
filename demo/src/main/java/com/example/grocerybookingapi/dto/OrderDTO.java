package com.example.grocerybookingapi.dto;

import java.util.List;

public class OrderDTO {
    private Long userId;
    private List<Long> groceryItemIds;

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getGroceryItemIds() {
        return groceryItemIds;
    }

    public void setGroceryItemIds(List<Long> groceryItemIds) {
        this.groceryItemIds = groceryItemIds;
    }
}
