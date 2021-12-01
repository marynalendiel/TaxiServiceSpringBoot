package com.taxiservicespring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

/**
 * Car entity.
 *
 * @author Maryna Lendiel
 */
@Entity(name = "Car")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car",
        uniqueConstraints = @UniqueConstraint(columnNames = {"car_number"}))
public class Car {
    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "car_number", nullable = false, unique = true)
    private String carNumber;

    @Column(name = "number_of_seats", nullable = false)
    private int numberOfSeats;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(
            mappedBy = "car",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CarLanguage> carLangDescriptions = new ArrayList<>();

    @ManyToMany(mappedBy = "cars")
    private List<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
        order.getCars().add(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.getCars().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return numberOfSeats == car.numberOfSeats && Objects.equals(id, car.id) && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(carNumber, car.carNumber) && Objects.equals(category, car.category) && Objects.equals(status, car.status) && Objects.equals(carLangDescriptions, car.carLangDescriptions) && Objects.equals(orders, car.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, carNumber, numberOfSeats, category, status, carLangDescriptions, orders);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", description='" + carLangDescriptions + '\'' +
                '}';
    }
}
