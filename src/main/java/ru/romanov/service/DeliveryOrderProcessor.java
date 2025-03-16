package ru.romanov.service;

import org.springframework.stereotype.Component;
import ru.romanov.dto.OrderDto;
import ru.romanov.enumiration.OrderType;

@Component
public class DeliveryOrderProcessor implements OrderProcessor {

    @Override
    public boolean accepts(OrderDto order) {
        return order.getOrderType().equals(OrderType.DELIVERY);
    }

    @Override
    public void processOrder(OrderDto order) {
        System.out.println("Order " + order.getOrderId() + " is taken for delivery. Searching for driver");
    }
}
