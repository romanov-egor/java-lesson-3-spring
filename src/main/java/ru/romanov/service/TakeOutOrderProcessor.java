package ru.romanov.service;

import org.springframework.stereotype.Service;
import ru.romanov.dto.OrderDto;
import ru.romanov.enumiration.OrderType;

@Service
public class TakeOutOrderProcessor implements OrderProcessor {

    @Override
    public boolean accepts(OrderDto order) {
        return order.getOrderType().equals(OrderType.TAKE_OUT);
    }

    @Override
    public void processOrder(OrderDto order) {
        System.out.println("Order " + order.getOrderId() + " is preparing. Waiting for customer");
    }
}
