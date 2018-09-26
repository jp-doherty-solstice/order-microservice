package com.doherty.ordermicroservice.services;

import com.doherty.ordermicroservice.entities.LineItem;
import com.doherty.ordermicroservice.models.LineItemSummary;
import com.doherty.ordermicroservice.repositories.LineItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
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

//    @Test
//    public void getLineItemSummary_ReturnsCorrectSummary() {
//        LineItem lineItem = new LineItem();
//        lineItem.setLineItemId(5);
//        lineItem.setQuantity(8);
//        when(lineItemRepository.getOne(any(Long.class)))
//                .thenReturn(lineItem);
//        when(productService.getName(any(Long.class)))
//                .thenReturn("basketball");
//        LineItemSummary foundSummary = lineItemService.getLineItemSummary(5L);
//        assertEquals("basketball", foundSummary.getProductName());
//        assertEquals(8, foundSummary.getQuantity());
//    }

//    @Test
//    public void calculateTotalPrice_ReturnsExpectedDouble() {
//        LineItem lineItem = new LineItem();
//        lineItem.setLineItemId(5);
//        lineItem.setQuantity(8);
//        when(lineItemRepository.getOne(any(Long.class)))
//                .thenReturn(lineItem);
//        when(productService.getPrice(any(Long.class)))
//                .thenReturn(74.32);
//        when(lineItemRepository.save(any(LineItem.class)))
//                .thenReturn(lineItem);
//        Double totalPrice = lineItemService.calculateTotalPrice(5L);
//        assertEquals(new Double(594.56), totalPrice);
//    }

}