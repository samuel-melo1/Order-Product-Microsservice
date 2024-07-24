package br.com.samuel.orderapi.service.impl;

import br.com.samuel.orderapi.domain.Order;
import br.com.samuel.orderapi.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("Order API Test Service")
class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl service;
    @Mock
    private OrderRepository repository;
    private Order order;
    private DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @BeforeEach
    void setUp() {
        mockOrder();
    }

    @Test
    @DisplayName("Creating order success in service")
    void create() {
    }

    @Test
    @DisplayName("Deleting order by id in service")
    void testDeleteById_WhenOrderAlredyExist_ThenDeleteOrderByIdReturnSuccess() {
        Mockito.when(repository.existsById(anyLong())).thenReturn(true);
        doNothing().when(repository).deleteById(anyLong());
        service.delete(1L);

        verify(repository, times(1)).deleteById(anyLong());
        verify(repository,times(1)).existsById(anyLong());
    }

    public void mockOrder() {
        List<Long> products = new ArrayList<>(List.of(1L));
        order = new Order(1L, LocalDateTime.of(2024, 12, 20, 14, 55), true, products);
    }
}