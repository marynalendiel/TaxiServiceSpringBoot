package com.taxiservicespring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "CarLanguage")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_has_language")
public class CarLanguage {
    @EmbeddedId
    private CarLanguageId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("carId")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("languageId")
    private Language language;

    @Column(name = "car_description")
    private String carDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarLanguage that = (CarLanguage) o;
        return Objects.equals(car, that.car) && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, language);
    }
}
