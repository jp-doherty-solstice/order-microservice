package com.doherty.ordermicroservice.repositories;

import com.doherty.ordermicroservice.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetail, Long> {

    @Query("select o from OrderDetail o where o.accountId = ?1")
    List<OrderDetail> findAllOrdersForAccount(Long id);

}
