package com.doherty.ordermicroservice.services;

import com.doherty.ordermicroservice.entities.LineItem;
import com.doherty.ordermicroservice.repositories.LineItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class LineItemServiceTest {

    @Mock
    private LineItemRepository lineItemRepository;

    @Mock
    private ProductService productService;

    @InjectMocks
    private LineItemService lineItemService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void assignShipmentToLineItem_AssignsTheShipment() {
        LineItem lineItem = createDummyLineItem();
        when(lineItemRepository.getOne(any(Long.class)))
                .thenReturn(lineItem);
        when(lineItemRepository.save(any(LineItem.class)))
                .thenReturn(lineItem);
        LineItem foundLineItem = lineItemService.assignShipmentToLineItem(5L, 6L);
        assertEquals(foundLineItem.getQuantity(), 14);
    }

    private LineItem createDummyLineItem() {
        LineItem lineItem = new LineItem();
        lineItem.setQuantity(14);
        return lineItem;
    }

}