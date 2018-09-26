package com.doherty.ordermicroservice.services;

import com.doherty.ordermicroservice.models.ShipmentSummary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "shipment-service")
@Component
public interface ShipmentService {

    @RequestMapping(value = "/shipmentSummary/{id}", method = RequestMethod.GET)
    ShipmentSummary getShipmentSummary(@PathVariable(value="id") Long id);

}
