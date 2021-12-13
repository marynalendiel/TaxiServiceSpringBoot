package com.taxiservicespring.service.impl;

import com.taxiservicespring.entity.Order;
import com.taxiservicespring.repository.OrderRepository;
import com.taxiservicespring.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int saveNewOrder(Order order) {
        orderRepository.saveOrder(order.getStartPoint(), order.getFinishPoint(), order.getDistance(),
                order.getPrice(), order.getNumberOfPassengers(), order.getUser().getId());
        BigInteger bigInteger = (BigInteger) entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();
        return bigInteger.intValue();

//        orderRepository.save(Order.builder()
//                .startPoint(order.getStartPoint())
//                .finishPoint(order.getFinishPoint())
//                .distance(order.getDistance())
//                .price(order.getPrice())
//                .numberOfPassengers(order.getNumberOfPassengers())
//                .user(order.getUser())
//                .build());
    }

    @Override
    public void insertCarToOrder(int carId, int orderId) {
        orderRepository.insertCarToOrder(carId, orderId);
    }

    @Override
    public List<Order> getOrderList() {
        return orderRepository.findAllOrders();
    }

    @Override
    public List<Order> getUserOrders(int userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public List<Order> getOrdersByDate(Date date) {
        return orderRepository.findByCreateTimeGreaterThanEqual(date);
    }
}
