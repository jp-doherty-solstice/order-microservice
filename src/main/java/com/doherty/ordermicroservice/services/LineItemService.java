package com.doherty.ordermicroservice.services;

import com.doherty.ordermicroservice.entities.LineItem;
import com.doherty.ordermicroservice.models.LineItemSummary;
import com.doherty.ordermicroservice.repositories.LineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class LineItemService {

    @Autowired
    LineItemRepository lineItemRepository;

    @Autowired
    ProductService productService;

    public LineItem assignShipmentToLineItem(Long lineItemId, Long shipmentId) {
        LineItem lineItem = lineItemRepository.getOne(lineItemId);
        lineItem.setShipmentId(shipmentId);
        return lineItemRepository.save(lineItem);
    }

    public LineItemSummary getLineItemSummary(Long id) {
        LineItem lineItem = lineItemRepository.getOne(id);
        LineItemSummary summary = new LineItemSummary();
        String productName = productService.getName(lineItem.getProductId());
        summary.setProductName(productName);
        summary.setQuantity(lineItem.getQuantity());
        return summary;
    }

    public Double calculateTotalPrice(Long id) {
        LineItem lineItem = lineItemRepository.getOne(id);
        Double price = productService.getPrice(lineItem.getProductId());
        Double totalPrice = price * lineItem.getQuantity();
        Double truncatedPrice = BigDecimal
                .valueOf(totalPrice)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        lineItem.setTotalPrice(truncatedPrice);
        return lineItemRepository.save(lineItem).getTotalPrice();
    }

}
