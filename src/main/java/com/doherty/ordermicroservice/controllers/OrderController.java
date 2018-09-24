package com.doherty.ordermicroservice.controllers;

import com.doherty.ordermicroservice.entities.LineItem;
import com.doherty.ordermicroservice.entities.OrderDetail;
import com.doherty.ordermicroservice.models.OrderSummary;
import com.doherty.ordermicroservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping("/orders/{id}/line")
    public void addLineItemForOrder(@PathVariable Long id, @RequestBody LineItem lineItem) {
        service.addLineItemForOrder(id, lineItem);
    }

    @GetMapping("/orders/{id}/lines")
    public @ResponseBody List<LineItem> getLineItemsForOrder(@PathVariable Long id) {
        return service.getLineItemsForOrder(id);
    }

    @GetMapping("/orders")
    public @ResponseBody List<OrderDetail> getAllOrdersForAccount(@RequestParam Long accountId) {
        return service.getAllOrdersForAccount(accountId);
    }

    @GetMapping("/orders/{id}")
    public OrderSummary getOrderSummary(@PathVariable Long id) {
        return service.getOrderSummary(id);
    }

}
