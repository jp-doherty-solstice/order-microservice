package com.doherty.ordermicroservice.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
public class OrderDetail {

    @Id
    @GeneratedValue
    private long orderNumber;

    private Long accountId;

    private Timestamp orderDate;

    private Long shippingAddressId;

    @OneToMany
    private Set<LineItem> lineItems;

    private double totalPrice;

    public OrderDetail() {
        this.orderDate = new Timestamp(System.currentTimeMillis());
    }

    public OrderDetail(Long accountId, Long shippingAddressId) {
        this.orderDate = new Timestamp(System.currentTimeMillis());
        this.accountId = accountId;
        this.shippingAddressId = shippingAddressId;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(Long shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
        this.totalPrice = 0.00;
        this.lineItems.forEach(lineItem -> {
            lineItem.setOrderDetail(this);
            this.totalPrice += lineItem.getTotalPrice();
        });
    }

}
