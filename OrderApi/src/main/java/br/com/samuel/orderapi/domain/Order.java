package br.com.samuel.orderapi.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_order;
    private LocalDateTime date_order;
    private Boolean paid;
    @ElementCollection
    @CollectionTable(name = "order-item",
    joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product_id")
    private Set<Long> products = new HashSet<>();

    public Order(){
    }
    public Order(Long id_order, LocalDateTime date_order, Boolean paid, List<Long> products) {
        this.id_order = id_order;
        this.date_order = date_order;
        this.paid = paid;
        this.products = new HashSet<>();
    }
    public Set<Long> getProducts() {
        return products;
    }
    public void setProducts(Set<Long> products) {
        this.products = products;
    }
    public Long getId_order() {
        return id_order;
    }
    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }
    public LocalDateTime getDate_order() {
        return date_order;
    }
    public void setDate_order(LocalDateTime date_order) {
        this.date_order = date_order;
    }
    public Boolean getPaid() {
        return paid;
    }
    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
