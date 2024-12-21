package com.example.grocerybookingapi.repository;

import com.example.grocerybookingapi.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
}