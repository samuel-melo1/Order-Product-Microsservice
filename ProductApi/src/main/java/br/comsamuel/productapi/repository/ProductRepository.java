package br.comsamuel.productapi.repository;

import br.comsamuel.productapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> {
}
