package ru.romanov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.romanov.dto.OrderDto;

import java.util.Map;

@RestController
public class OrderCreationController {

    @Autowired
    private Map<Integer, OrderDto> inMemoryOrders;

    @PostMapping("/add")
    public OrderDto addOrder(@RequestBody OrderDto order) {
        inMemoryOrders.put(Integer.valueOf(order.getOrderId()), order);
        return order;
    }
}
