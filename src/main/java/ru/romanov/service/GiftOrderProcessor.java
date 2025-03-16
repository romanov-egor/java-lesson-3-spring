package ru.romanov.service;

import org.springframework.stereotype.Component;
import ru.romanov.dto.OrderDto;
import ru.romanov.service.OrderProcessor;

@Component
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
