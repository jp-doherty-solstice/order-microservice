package com.doherty.ordermicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class LineItem {

    @Id
    @GeneratedValue
    private long lineItemId;

    private Long productId;

    @ManyToOne
    @JoinColumn(name = "orderNumber")
    @JsonIgnore
    private OrderDetail orderDetail;

    private int quantity;

    private double totalPrice;

    private Long shipmentId;

    public LineItem() {
    }

    public LineItem(Long productId, int quantity, OrderDetail orderDetail) {
        this.productId = productId;
        this.quantity = quantity;
        this.orderDetail = orderDetail;
    }

    public long getLineItemId() {
        return lineItemId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

}
