package com.taxiservicespring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Language entity.
 *
 * @author Maryna Lendiel
 */
@Entity(name = "Language")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "language",
        uniqueConstraints = @UniqueConstraint(columnNames = {"language_code", "language_name"}))
public class Language {
    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "language_code", nullable = false, unique = true)
    private String languageCode;

    @Column(name = "language_name", nullable = false, unique = true)
    private String languageName;

    @OneToMany(
            mappedBy = "language",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CarLanguage> languageDescriptions = new ArrayList<>();
}
