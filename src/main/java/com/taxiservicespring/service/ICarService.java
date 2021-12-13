package com.taxiservicespring.service;

import com.taxiservicespring.entity.Car;
import com.taxiservicespring.entity.enums.Status;

import java.util.List;

public interface ICarService {
    Car getCarByCategory(String category);

    List<Car> getCarsByCategory(String category);

    Car getCarByNumberOfSeats(int numberOfSeats);

    void updateCarStatus(int id, Status status);

    List<Car> getAllCars();

    List<Car> getCarsByOrderId(int orderId);
}
