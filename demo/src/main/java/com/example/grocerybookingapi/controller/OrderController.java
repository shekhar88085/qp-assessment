package com.example.grocerybookingapi.controller;

import com.example.grocerybookingapi.dto.OrderDTO;
import com.example.grocerybookingapi.entity.Order;
import com.example.grocerybookingapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody OrderDTO orderDTO) {
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setGroceryItemIds(orderDTO.getGroceryItemIds());
        return orderService.placeOrder(order);
    }
}