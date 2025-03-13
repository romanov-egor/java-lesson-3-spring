package ru.romanov.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.romanov.dto.ItemDto;
import ru.romanov.dto.OrderDto;
import ru.romanov.enumiration.OrderStatus;
import ru.romanov.enumiration.OrderType;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    private Map<Integer, OrderDto> orders;

    @GetMapping("/init")
    public void getOrders() {
        orders = Map.of(
                1, new OrderDto("1", Collections.emptyList(), OrderType.DELIVERY, OrderStatus.ACTIVE),
                2, new OrderDto("2", List.of(new ItemDto("juice", 10.0)), OrderType.DELIVERY, OrderStatus.ACTIVE),
                3, new OrderDto("3", Collections.emptyList(), OrderType.TAKE_OUT, OrderStatus.DELIVERED),
                4, new OrderDto("4", Collections.emptyList(), OrderType.TAKE_OUT, OrderStatus.DELIVERED)
        );
    }

    @GetMapping("/orders")
    public Map<Integer, OrderDto> getOrdersList() {
        return orders;
    }

    @PostMapping("/orders/{id}/cancel")
    public ResponseEntity<OrderDto> cancelOrder(@PathVariable("id") Integer id) {
        OrderDto order = orders.get(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        order.cancel();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
