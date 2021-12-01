package com.taxiservicespring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User entity.
 *
 * @author Maryna Lendiel
 */
@Entity(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user",
        uniqueConstraints = @UniqueConstraint(columnNames = {"login", "phone_number", "email"}))
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "role", nullable = false)
    private boolean role;

    @Column(name = "discount", nullable = false)
    private boolean discount;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phoneNumber + '\'' +
                ", role=" + role +
                ", discount=" + discount +
                ", create_time=" + createTime +
                '}';
    }
}
