package br.comsamuel.productapi.service.Impl;

import br.comsamuel.productapi.domain.Product;
import br.comsamuel.productapi.repository.ProductRepository;
import br.comsamuel.productapi.service.enums.StatusErrorEnum;
import br.comsamuel.productapi.service.exception.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl service;
    @Mock
    private ProductRepository repository;

    private Product product;
    private Optional<Product> optionalProduct;
    @BeforeEach
    void setUp() {
        MockProductEntity();
    }
    @Test
    @DisplayName("Product created with success")
    void testSaveProduct_WhenProductIsNotHaveBeenCreated_ShouldReturnSuccess() {
        when(repository.save(any())).thenReturn(product);
        when(repository.findById(anyLong())).thenReturn(optionalProduct);

        Product product2 = service.saveProduct(product);
        Assertions.assertNotNull(product2);
        Assertions.assertEquals("TV", product2.getName());
        Assertions.assertEquals("Using to watching movie", product2.getDescription());
        Assertions.assertEquals(2000.0, product2.getPrice());
        Assertions.assertEquals(Product.class, product2.getClass());
    }
    @Test
    @DisplayName("Product result did not expected")
    void testSaveProduct_WhenProductAlredyBeenCreated_ShouldReturnExceptionAlredyExist() {
        when(repository.save(any())).thenReturn(product);
        
        Exception thrown = assertThrows(ObjectNotFoundException.class, () -> {
            service.saveProduct(product);
        });
        assertEquals(ObjectNotFoundException.class, thrown.getClass());
        assertEquals("Object product not found!", thrown.getMessage());
    }

    public void MockProductEntity(){
        product = new Product(1L, "TV", "Using to watching movie", 2000.0);
        optionalProduct = Optional.of(new Product(1L, "TV", "Using to watching movie", 2000.0));
    }
}