package com.taxiservicespring.repository;

import com.taxiservicespring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.user.id = :id")
    List<Order> findAllByUserId(Long id);

    @Query("select o from Order o where o.user.id = :id")
    Order findByUserId(@Param("id") Long id);

    @Query("select o from Order o where o.createTime >= :createTime")
    List<Order> findByCreateTimeGreaterThanEqual(Date createTime);




}