package org.dbmlab.orders.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "OrderItem")
public class OrderItem {

    @Id
    @Column(nullable = false, columnDefinition = "uniqueidentifier")
    private String id = UUID.randomUUID().toString();
    @ManyToOne(optional = false)
    private Order order;
    @Column(nullable = false)
    private String productCode;
    @Column(nullable = true)
    private String notes;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Double quantity;
    @Column(nullable = false)
    private Double totalAmount;
    @Column
    @Version
    private Long version;

    public UUID getId() {
        return UUID.fromString(id);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}