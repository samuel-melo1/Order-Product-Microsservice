package br.com.samuel.orderapi.repository;

import br.com.samuel.orderapi.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
