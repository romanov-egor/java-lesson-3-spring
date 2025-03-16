package ru.romanov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.romanov.dto.OrderDto;
import ru.romanov.service.DeliveryOrderProcessor;
import ru.romanov.service.GiftOrderProcessor;
import ru.romanov.service.OrderProcessor;
import ru.romanov.service.TakeOutOrderProcessor;
import ru.romanov.service.TestDataCache;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private Map<Integer, OrderDto> inMemoryOrders;

    @Autowired
    private TestDataCache testDataCache;

    @Autowired
    private List<OrderProcessor> processors;

    @GetMapping("/orders")
    public Map<Integer, OrderDto> getOrdersList() {
        return inMemoryOrders;
    }

    @GetMapping("/orders/process")
    public TestDataCache processOrders() {
        return testDataCache;
    }

    @PostMapping("/orders/{id}/cancel")
    public ResponseEntity<OrderDto> cancelOrder(@PathVariable("id") Integer id) {
        OrderDto order = inMemoryOrders.get(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        order.cancel();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
