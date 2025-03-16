package ru.romanov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.romanov.dto.OrderDto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class InMemoryDataConfig {

    @Bean
    public Map<Integer, OrderDto> inMemoryOrders() {
        return new LinkedHashMap<>();
    }
}
