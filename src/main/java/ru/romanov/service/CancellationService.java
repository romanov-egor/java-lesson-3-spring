package ru.romanov.service;

import ru.romanov.dto.Cancellable;
import ru.romanov.dto.OrderDto;
import ru.romanov.enumiration.OrderStatus;

public class CancellationService {

    public void cancel(Cancellable cancellable) {
        cancellable.cancel();
    }
}
