package com.taxiservicespring.repository;

import com.taxiservicespring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("select c from Car c left join c.orders orders where orders.id = ?1")
    List<Car> findByOrdersId(@Param("id") Long id, @Param("language") String language);

    @Query("select c from Car c left join c.carLangDescriptions carLangDescriptions where c.numberOfSeats = ?1 and c.status = 'to order' and carLangDescriptions.language.languageCode = ?3")
    Car findByNumberOfSeatsAndStatusAndLanguageCode(@Param("numberOfSeats") int numberOfSeats, @Param("languageCode") String languageCode);

    @Query("select c from Car c left join c.carLangDescriptions carLangDescriptions where c.category = ?1 and c.status = 'to order' and carLangDescriptions.language.languageCode = ?3")
    List<Car> findByCategoryAndStatusAndCarLangDescriptionsLanguageLanguageCode(@Param("category") String category, @Param("languageCode") String languageCode);

}