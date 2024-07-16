package br.com.samuel.orderapi.service;

import br.com.samuel.orderapi.client.ProductFeign;
import br.com.samuel.orderapi.client.domain.Product;
import br.com.samuel.orderapi.domain.Order;
import br.com.samuel.orderapi.repository.OrderRepository;
import br.com.samuel.orderapi.service.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductFeign feign;

    @Transactional
    public Order create(Order order) {
        List<Product> productList = new ArrayList<>();
        for (Long productId : order.getProducts()) {
            try {
                var product = feign.findById(productId);
                productList.add(product);
            }catch (ObjectNotFoundException exception){
                exception.getMessage();
            }
        }
        return repository.save(order);
    }
}
