package com.taxiservicespring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
//table = "car_has_language",
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarLanguageId implements Serializable {
    @Column(name = "car_id")
    private Long carId;

    @Column(name = "language_id")
    private Long languageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarLanguageId that = (CarLanguageId) o;
        return Objects.equals(carId, that.carId) && Objects.equals(languageId, that.languageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, languageId);
    }
}
