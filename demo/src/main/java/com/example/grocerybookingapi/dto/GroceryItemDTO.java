package com.example.grocerybookingapi.dto;

import lombok.Data;

@Data
public class GroceryItemDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer inventory;
}