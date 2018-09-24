package com.doherty.ordermicroservice.services;

import com.doherty.ordermicroservice.models.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class OrderServiceTest {

//    @Autowired
//    @Qualifier(value = "orderService")
//    private OrderService orderService;
//
//    @MockBean
//    private AddressService addressService;
//
//    @Before
//    public void setUp() {
//        Address address = new Address();
//        address.setStreet("45 Mystic");
//        Mockito.when(addressService.getAddressById(any(Long.class))).thenReturn(address);
//    }
//
//    @Test
//    public void getShippingAddressFromId_WithValidId_ReturnsAddress() {
//        Address found = orderService.getShippingAddressFromId(5L);
//        assertThat(found.getStreet()).isEqualTo("45 Mystic");
//    }

}