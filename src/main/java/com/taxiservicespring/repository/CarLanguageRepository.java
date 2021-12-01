package com.taxiservicespring.repository;

import com.taxiservicespring.entity.CarLanguage;
import com.taxiservicespring.entity.CarLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarLanguageRepository extends JpaRepository<CarLanguage, CarLanguageId> {
}