package com.example.grocerybookingapi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grocery_order") // Avoid using "order" as the table name.
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ElementCollection
    private List<Long> groceryItemIds;

    // Default Constructor
    public Order() {
    }

    // Parameterized Constructor
    public Order(Long id, Long userId, List<Long> groceryItemIds) {
        this.id = id;
        this.userId = userId;
        this.groceryItemIds = groceryItemIds;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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