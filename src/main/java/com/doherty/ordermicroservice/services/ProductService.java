package com.doherty.ordermicroservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product-service")
public interface ProductService {

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getProductNameFromId(@PathVariable(value="id") Long id);

}
