package com.doherty.ordermicroservice.repositories;

import com.doherty.ordermicroservice.entities.LineItem;
import com.doherty.ordermicroservice.entities.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class LineItemRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LineItemRepository lineItemRepository;

    @Test
    public void fineAllLineItemsForOrder_WithValidOrderId_ReturnsLineItems() {

        OrderDetail orderDetail = new OrderDetail(4L, 6L);
        LineItem lineItem1 = new LineItem(7L, 8, orderDetail);
        LineItem lineItem2 = new LineItem(31L, 3, orderDetail);
        LineItem lineItem3 = new LineItem(2L, 19, orderDetail);

        Long orderId = (Long) entityManager.persistAndGetId(orderDetail);
        entityManager.persist(lineItem1);
        entityManager.persist(lineItem2);
        entityManager.persist(lineItem3);
        entityManager.flush();

        List<LineItem> foundLineItems = lineItemRepository.findAllLineItemsForOrder(orderId);

        assertThat(foundLineItems.size()).isEqualTo(3);
        assertThat(lineItem1).isIn(foundLineItems);

    }




}