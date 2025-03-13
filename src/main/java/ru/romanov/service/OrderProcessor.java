package ru.romanov.service;

import ru.romanov.dto.OrderDto;

public interface OrderProcessor {

    boolean accepts(OrderDto order);

    void processOrder(OrderDto order);
}
