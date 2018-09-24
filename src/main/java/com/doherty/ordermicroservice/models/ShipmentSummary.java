package com.doherty.ordermicroservice.models;

import java.sql.Timestamp;
import java.util.List;

public class ShipmentSummary {

    private List<LineItemSummary> lineItems;
    private Timestamp shippedDate;
    private Timestamp  deliveryDate;

    public ShipmentSummary() {
    }

    public List<LineItemSummary> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemSummary> lineItems) {
        this.lineItems = lineItems;
    }

    public Timestamp getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Timestamp shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

}
