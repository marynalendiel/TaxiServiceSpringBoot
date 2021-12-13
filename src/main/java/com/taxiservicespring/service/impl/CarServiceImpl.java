package com.taxiservicespring.service.impl;

import com.taxiservicespring.entity.Car;
import com.taxiservicespring.entity.enums.Category;
import com.taxiservicespring.entity.enums.Status;
import com.taxiservicespring.repository.CarRepository;
import com.taxiservicespring.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car getCarByCategory(String category) {
        return carRepository.findFirstByStatusAndCategoryOrderByStatusAsc(Status.valueOf("TO_ORDER"), Category.valueOf(category));
    }

    @Override
    public List<Car> getCarsByCategory(String category) {
        return carRepository.findByStatusAndCategory(Status.valueOf("TO_ORDER"), Category.valueOf(category));
    }

    @Override
    public Car getCarByNumberOfSeats(int numberOfSeats) {
        return carRepository.findFirstByStatusAndNumberOfSeatsGreaterThanEqualOrderByStatusAsc(Status.valueOf("TO_ORDER"), numberOfSeats);
    }

    @Override
    public void updateCarStatus(int id, Status status) {
        carRepository.updateCarStatus(id, status);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAllCars();
    }

    @Override
    public List<Car> getCarsByOrderId(int orderId) {
        return carRepository.findByOrders_Id(orderId);
    }


}
