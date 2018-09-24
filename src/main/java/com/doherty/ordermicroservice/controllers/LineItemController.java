package com.doherty.ordermicroservice.controllers;

import com.doherty.ordermicroservice.models.LineItemSummary;
import com.doherty.ordermicroservice.services.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LineItemController {

    @Autowired
    LineItemService lineItemService;

    @RequestMapping(value = "/lineItems/{lineItemId}/assign/{shipmentId}", method = RequestMethod.POST)
    public void assignShipmentToLineItem(@PathVariable("lineItemId") Long lineItemId, @PathVariable("shipmentId") Long shipmentId) {
        lineItemService.assignShipmentToLineItem(lineItemId, shipmentId);
    }

    @RequestMapping(value = "/lineItems/{id}/summary", method = RequestMethod.GET)
    public LineItemSummary getLineItemSummary(@PathVariable("id") Long id) {
        return lineItemService.getLineItemSummary(id);
    }

}
