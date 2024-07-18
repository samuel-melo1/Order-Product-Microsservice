package br.com.samuel.orderapi.service.impl;

import br.com.samuel.orderapi.client.ProductFeign;
import br.com.samuel.orderapi.client.domain.Product;
import br.com.samuel.orderapi.domain.Order;
import br.com.samuel.orderapi.repository.OrderRepository;
import br.com.samuel.orderapi.service.OrderService;
import br.com.samuel.orderapi.service.exception.ObjectNotFoundException;
import br.com.samuel.orderapi.service.response.StatusErrorEnum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductFeign feign;

    @Transactional
    @Override
    public Order create(Order order) {
        List<Product> productList = new ArrayList<>();
        for (Long productId : order.getProducts()) {
            var product = feign.findById(productId);
            productList.add(product);
        }
        return repository.save(order);
    }
    @Override
    public void delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        throw new ObjectNotFoundException(StatusErrorEnum.NOT_FOUND);
    }
}
