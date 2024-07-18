package br.com.samuel.orderapi.service;


import br.com.samuel.orderapi.domain.Order;

public interface OrderService {

    Order create(Order order);

    void delete(Long id);
}