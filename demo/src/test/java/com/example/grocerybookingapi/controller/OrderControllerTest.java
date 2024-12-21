package com.example.grocerybookingapi.controller;

import com.example.grocerybookingapi.dto.OrderDTO;
import com.example.grocerybookingapi.entity.Order;
import com.example.grocerybookingapi.repository.OrderRepository;
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

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private OrderDTO orderDTO;

    @BeforeEach
    public void setUp() {
        orderDTO = new OrderDTO();
        orderDTO.setUserId(1L);
        List<Long> groceryItemIds = new ArrayList<>();
        groceryItemIds.add(1L);
        groceryItemIds.add(2L);
        orderDTO.setGroceryItemIds(groceryItemIds);

    }

    @Test
    public void testPlaceOrder() throws Exception {
        mockMvc.perform(post("/user/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1L))
                .andExpect(jsonPath("$.groceryItemIds[0]").value(1L))
                .andExpect(jsonPath("$.groceryItemIds[1]").value(2L));
    }
}