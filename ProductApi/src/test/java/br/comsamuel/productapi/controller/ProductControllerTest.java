package br.comsamuel.productapi.controller;

import br.comsamuel.productapi.domain.Product;
import br.comsamuel.productapi.repository.ProductRepository;
import br.comsamuel.productapi.service.Impl.ProductServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@DisplayName("Product Test Controller")
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductServiceImpl service;
    private Product product;
    private Optional<Product> optionalProduct;
    private List<Product> products;
    private ObjectMapper mapper = new ObjectMapper();
    @BeforeEach
    void setUp() {
        mapper.registerModule(new Jdk8Module());
        MockProductEntity();
    }
    @Test
    @DisplayName("Testing creating product in controller")
    void testSaveProduct_WhenProductIsNotHaveBeenCreated_ShouldReturnSuccess() throws Exception {
        when(service.saveProduct(any())).thenReturn(product);
        String reqBody = new ObjectMapper().writeValueAsString(product);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/create")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content(reqBody)
        ).andExpect(MockMvcResultMatchers.status().isOk());

        Assertions.assertNotNull(reqBody);
        Mockito.verify(this.service, Mockito.times(1)).saveProduct(Mockito.any(Product.class));
    }
    @Test
    @DisplayName("Testing find all products in controller")
    void testFindAll_WhenExistOneOrMoreProductInDataBase_ShouldReturnListProducts() throws Exception {
        when(service.findAllProducts()).thenReturn(products);
        String reqBody = new ObjectMapper().writeValueAsString(products);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content(reqBody)
        ).andExpect(MockMvcResultMatchers.status().isOk());

        Assertions.assertNotNull(reqBody);
        Mockito.verify(this.service, Mockito.times(1)).findAllProducts();
    }
    @Test
    @DisplayName("Testing findById Product in controller")
    void testFindById_WhenProductByIdExistInDataBase_ShouldReturnProduct() throws Exception {

        when(service.findById(1L)).thenReturn(optionalProduct);
        String reqBody = mapper.writeValueAsString(optionalProduct);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content(reqBody)
        ).andExpect(MockMvcResultMatchers.status().isOk());

        Assertions.assertNotNull(reqBody);
        Mockito.verify(this.service, Mockito.times(1)).findById(1L);
    }

    public void MockProductEntity(){
        products = List.of(new Product(1L, "TV", "Using to watching movie", 2000.0),
                           new Product(2L, "Ar Conditioner", "Using at the summer", 3000.0));

        product = new Product(1L, "TV", "Using to watching movie", 2000.0);
        optionalProduct = Optional.of(new Product(1L, "TV", "Using to watching movie", 2000.0));
    }
}