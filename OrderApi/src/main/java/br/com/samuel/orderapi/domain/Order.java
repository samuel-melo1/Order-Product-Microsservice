package br.com.samuel.orderapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_order;
    private LocalDateTime date_order;
    private Boolean paid;

    public Order(){
    }
    public Order(Long id_order, LocalDateTime date_order, Boolean paid) {
        this.id_order = id_order;
        this.date_order = date_order;
        this.paid = paid;
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
