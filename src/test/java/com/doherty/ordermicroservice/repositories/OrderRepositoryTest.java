package com.doherty.ordermicroservice.repositories;

import com.doherty.ordermicroservice.entities.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void findAllOrdersForAccount_WithValidAccountId_ReturnsListOfOrders() {

        OrderDetail orderDetail1 = new OrderDetail(4L, 6L);
        OrderDetail orderDetail2 = new OrderDetail(4L, 3L);
        OrderDetail orderDetail3 = new OrderDetail(4L, 8L);

        entityManager.persist(orderDetail1);
        entityManager.persist(orderDetail2);
        entityManager.persist(orderDetail3);
        entityManager.flush();

        List<OrderDetail> foundOrderDetails = orderRepository.findAllOrdersForAccount(4L);

        assertThat(foundOrderDetails.size()).isEqualTo(3);
        assertThat(orderDetail1).isIn(foundOrderDetails);
    }

}