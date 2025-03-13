package ru.romanov.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.romanov.enumiration.OrderStatus;
import ru.romanov.enumiration.OrderType;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Cancellable {
    private String orderId;
    private List<ItemDto> items;
    private OrderType orderType;
    private OrderStatus orderStatus = OrderStatus.ACTIVE;

    @Override
    public void cancel() {
        orderStatus = OrderStatus.CANCELLED;
        items.clear();
    }
}
