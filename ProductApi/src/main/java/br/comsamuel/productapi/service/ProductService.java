package br.comsamuel.productapi.service;

import br.comsamuel.productapi.domain.Product;

import java.util.List;
import java.util.Optional;
public interface ProductService {
     Product saveProduct(Product product);
     Optional<Product> findById(Long id);
     List<Product> findAllProducts();

}
