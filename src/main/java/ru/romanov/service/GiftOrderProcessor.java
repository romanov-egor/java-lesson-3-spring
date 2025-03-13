package ru.romanov.service;

import ru.romanov.dto.OrderDto;
import ru.romanov.service.OrderProcessor;

public class GiftOrderProcessor implements OrderProcessor {
    @Override
    public boolean accepts(OrderDto order) {
        return false;
    }

    @Override
    public void processOrder(OrderDto order) {
        throw new UnsupportedOperationException();
    }
}
