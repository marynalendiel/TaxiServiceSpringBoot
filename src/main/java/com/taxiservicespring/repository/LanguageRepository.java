package com.taxiservicespring.repository;

import com.taxiservicespring.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}