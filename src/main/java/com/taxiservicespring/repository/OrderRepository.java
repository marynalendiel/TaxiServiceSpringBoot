package com.taxiservicespring.repository;

import com.taxiservicespring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("select o from Order o")
    List<Order> findAllOrders();

    @Query("select o from Order o where o.user.id = :id")
    List<Order> findAllByUserId(Integer id);

    @Query("select o from Order o where o.createTime >= :createTime")
    List<Order> findByCreateTimeGreaterThanEqual(Date createTime);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `order` (start_point, finish_point, distance, price, number_of_passengers, user_id) " +
            "VALUES (:start_point, :finish_point, :distance, :price, :number_of_passengers, :user_id) " +
            "ON DUPLICATE KEY UPDATE " +
            "start_point=:start_point, finish_point=:finish_point, distance=:distance, price=:price, " +
            "number_of_passengers=:number_of_passengers, user_id=:user_id", nativeQuery = true)
    void saveOrder(@Param("start_point") String startPoint, @Param("finish_point") String finishPoint,
                    @Param("distance") double distance, @Param("price") double price,
                    @Param("number_of_passengers") int numberOfPassengers, @Param("user_id") int userId);

    @Transactional
    @Modifying
    @Query(value = "insert into `order_has_car` (order_id, car_id) values (:order_id, :car_id) " +
            "on duplicate key update order_id=:order_id, car_id=:car_id", nativeQuery = true)
    void insertCarToOrder(@Param("car_id") int carId, @Param("order_id") int orderId);


}