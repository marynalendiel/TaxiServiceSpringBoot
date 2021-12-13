package com.taxiservicespring.repository;

import com.taxiservicespring.entity.Car;
import com.taxiservicespring.entity.enums.Category;
import com.taxiservicespring.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("select c from Car c")
    List<Car> findAllCars();

    @Query("select c from Car c where c.id = ?1")
    Car findCarById(Long id);

    Car findFirstByStatusAndCategoryOrderByStatusAsc(Status status, Category category);

    @Query("select c from Car c where c.status = ?1 and c.category = ?2")
    List<Car> findByStatusAndCategory(Status status, Category category);

    @Modifying
    @Query("update Car c set c.status = :status where c.id = :id")
    void updateCarStatus(@Param(value = "id") int id, @Param(value = "status") Status status);

    Car findFirstByStatusAndNumberOfSeatsGreaterThanEqualOrderByStatusAsc(Status status, int numberOfSeats);

    @Query("select c from Car c left join c.orders orders where orders.id = ?1")
    List<Car> findByOrders_Id(int id);




}