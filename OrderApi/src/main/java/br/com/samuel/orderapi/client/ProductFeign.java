package br.com.samuel.orderapi.client;

import br.com.samuel.orderapi.client.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "product-api", url = "http://localhost:8082")
public interface ProductFeign {

    @GetMapping("/api/v1/products")
    ResponseEntity<List<Product>> findAll();

    @GetMapping(value = "/api/v1/{id}")
    ResponseEntity<Optional<Product>> findById(@PathVariable("id") Long id);
}
