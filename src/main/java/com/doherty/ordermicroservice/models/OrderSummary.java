package com.doherty.ordermicroservice.models;

import com.doherty.ordermicroservice.entities.LineItem;

import java.util.List;
import java.util.Set;

public class OrderSummary {

    private Long orderNumber;
    private Address shippingAddress;
    private Double price;
    private List<LineItemSummary> lineItems;
    private List<ShipmentSummary> shipments;

    public OrderSummary() {
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<LineItemSummary> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemSummary> lineItems) {
        this.lineItems = lineItems;
    }

    public List<ShipmentSummary> getShipments() {
        return shipments;
    }

    public void setShipments(List<ShipmentSummary> shipments) {
        this.shipments = shipments;
    }

}
