package com.taxiservicespring.service;

import com.taxiservicespring.entity.Order;

import java.util.Date;
import java.util.List;

public interface IOrderService {
    int saveNewOrder(Order order);

    void insertCarToOrder(int carId, int orderId);

    List<Order> getOrderList();

    List<Order> getUserOrders(int userId);

    List<Order> getOrdersByDate(Date date);
}
