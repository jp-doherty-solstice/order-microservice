package com.doherty.ordermicroservice.repositories;

import com.doherty.ordermicroservice.entities.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long> {

    @Query("select l from LineItem l where l.orderDetail.orderNumber = ?1")
    List<LineItem> findAllLineItemsForOrder(Long id);

}
