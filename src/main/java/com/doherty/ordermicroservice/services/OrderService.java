package com.doherty.ordermicroservice.services;

import com.doherty.ordermicroservice.entities.LineItem;
import com.doherty.ordermicroservice.entities.OrderDetail;
import com.doherty.ordermicroservice.models.Address;
import com.doherty.ordermicroservice.models.LineItemSummary;
import com.doherty.ordermicroservice.models.OrderSummary;
import com.doherty.ordermicroservice.models.ShipmentSummary;
import com.doherty.ordermicroservice.repositories.LineItemRepository;
import com.doherty.ordermicroservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    LineItemRepository lineItemRepository;

    @Autowired
    AddressService addressService;

    @Autowired
    ProductService productService;

    @Autowired
    ShipmentService shipmentService;

    public void addLineItemForOrder(Long id, LineItem lineItem) {
        OrderDetail order = orderRepository.getOne(id);
        lineItem.setOrderDetail(order);
        lineItemRepository.save(lineItem);
    }

    public List<LineItem> getLineItemsForOrder(Long id) {
        return lineItemRepository.findAllLineItemsForOrder(id);
    }

    public List<OrderDetail> getAllOrdersForAccount(Long accountId) {
        return orderRepository.findAllOrdersForAccount(accountId);
    }

    public OrderSummary getOrderSummary(Long id) {
        OrderDetail order = orderRepository.getOne(id);
        Address shippingAddress = addressService.getAddressById(id);
        return buildOrderSummaryFromOrderAndShippingAddress(order, shippingAddress);
    }

    private OrderSummary buildOrderSummaryFromOrderAndShippingAddress(OrderDetail order, Address shippingAddress) {
        OrderSummary summary = new OrderSummary();
        summary.setOrderNumber(order.getOrderNumber());
        summary.setShippingAddress(shippingAddress);
        summary.setPrice(getTotalPriceFromLineItems(order.getLineItems()));
        summary.setLineItems(getLineItemSummariesFromLineItems(order.getLineItems()));
        summary.setShipments( getShipmentSummariesFromLineItems( order.getLineItems() ) );
        return summary;
    }

    private Double getTotalPriceFromLineItems(Set<LineItem> lineItems) {
        Double total = Double.valueOf(0);
        for (LineItem item : lineItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    private List<LineItemSummary> getLineItemSummariesFromLineItems(Set<LineItem> lineItems) {
        List<LineItemSummary> summaries = new ArrayList<>();
        for (LineItem item : lineItems) {
            LineItemSummary summary = new LineItemSummary();
            String productName = productService.getProductNameFromId(item.getProductId());
            summary.setProductName(productName);
            summary.setQuantity(item.getQuantity());
            summaries.add(summary);
        }
        return summaries;
    }

    private List<ShipmentSummary> getShipmentSummariesFromLineItems(Set<LineItem> lineItems) {
        List<Long> shipmentIds = new ArrayList<>();
        for (LineItem lineItem : lineItems) {
            if (!shipmentIds.contains(lineItem.getShipmentId())) {
                shipmentIds.add(lineItem.getShipmentId());
            }
        }
        List<ShipmentSummary> summaries = new ArrayList<>();
        for (Long id : shipmentIds) {
            ShipmentSummary summary = shipmentService.getShipmentSummary(id);
            summaries.add(summary);
        }
        return summaries;
    }

}
