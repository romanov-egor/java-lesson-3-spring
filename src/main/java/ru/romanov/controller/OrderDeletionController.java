package ru.romanov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.romanov.dto.OrderDto;

import java.util.Map;

@RestController
public class OrderDeletionController {

    @Autowired
    private Map<Integer, OrderDto> inMemoryOrders;

    @DeleteMapping("/delete/{id}")
    public OrderDto deleteOrder(@PathVariable("id") Integer id) {
        return inMemoryOrders.remove(id);
    }
}
