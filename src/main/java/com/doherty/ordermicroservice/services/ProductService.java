package com.doherty.ordermicroservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product-microservice")
@Component
public interface ProductService {

    @RequestMapping(value = "/product/{id}/name", method = RequestMethod.GET)
    String getName(@PathVariable(value="id") Long id);

    @RequestMapping(value = "/product/{id}/price", method = RequestMethod.GET)
    Double getPrice(@PathVariable(value="id") Long id);

}
