package br.comsamuel.productapi.controller;

import br.comsamuel.productapi.domain.Product;
import br.comsamuel.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/api/v1")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody Product product){
        return ResponseEntity.ok(service.saveProduct(product));
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(service.findAllProducts());
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
