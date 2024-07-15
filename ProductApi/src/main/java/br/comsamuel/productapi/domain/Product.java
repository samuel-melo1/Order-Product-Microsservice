package br.comsamuel.productapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;
    private String name;
    private String description;
    private Double price;

    public Product(){
    }
    public Product(Long id_product, String name, String description, Double price) {
        this.id_product = id_product;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Long getId_product() {
        return id_product;
    }
    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
