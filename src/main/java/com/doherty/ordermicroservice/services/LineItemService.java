package com.doherty.ordermicroservice.services;

import com.doherty.ordermicroservice.entities.LineItem;
import com.doherty.ordermicroservice.models.LineItemSummary;
import com.doherty.ordermicroservice.repositories.LineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        String productName = productService.getProductNameFromId(lineItem.getProductId());
        summary.setProductName(productName);
        summary.setQuantity(lineItem.getQuantity());
        return summary;
    }

}
