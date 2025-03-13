package ru.romanov.service;

import ru.romanov.dto.ItemDto;
import ru.romanov.dto.OrderDto;
import ru.romanov.enumiration.OrderType;
import ru.romanov.service.CancellationService;
import ru.romanov.service.OrderProcessor;

public class DeliveryOrderProcessor implements OrderProcessor {

    @Override
    public boolean accepts(OrderDto order) {
        return order.getOrderType().equals(OrderType.DELIVERY);
    }

    @Override
    public void processOrder(OrderDto order) {
        CancellationService cancellationService = new CancellationService();

        double orderPrice = 0.0;
        for (ItemDto item : order.getItems()) {
            orderPrice = orderPrice + item.getItemPrice();
        }
        if (orderPrice < 100.0) {
            cancellationService.cancel(order);
            System.out.println("Order " + order.getOrderId() + " cancelled");
        } else {
            System.out.println("Order " + order.getOrderId() + " is taken for delivery. Searching for driver");
        }
    }
}
