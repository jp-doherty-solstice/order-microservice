package com.doherty.ordermicroservice.fallbacks;

import com.doherty.ordermicroservice.services.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductFallback implements ProductService {

    @Override
    public String getName(Long id) {
        return "---name not available---";
    }

    @Override
    public Double getPrice(Long id) {
        return 0.00;
    }

}