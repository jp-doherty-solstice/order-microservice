package com.doherty.ordermicroservice.services;

import com.doherty.ordermicroservice.models.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "account-service")
@Component
public interface AddressService {

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public Address getAddressById(@PathVariable(value="id") Long id);

}
