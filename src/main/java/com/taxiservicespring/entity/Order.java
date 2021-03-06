package com.taxiservicespring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Order entity.
 *
 * @author Maryna Lendiel
 */
@Entity(name = "Order")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private int id;

    @Column(name = "start_point", nullable = false)
    private String startPoint;

    @Column(name = "finish_point", nullable = false)
    private String finishPoint;

    @Column(name = "distance", nullable = false)
    private double distance;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "number_of_passengers", nullable = false)
    private int numberOfPassengers;

    @Column(name = "create_time", nullable = false)
    @CreationTimestamp
    private Date createTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "order_has_car",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<Car> cars = new ArrayList<>();

    @Override
    public String toString() {
        return "Order{" +
                "startPoint='" + startPoint + '\'' +
                ", finishPoint='" + finishPoint + '\'' +
                ", distance=" + distance +
                ", price=" + price +
                ", createTime=" + createTime +
                ", user=" + user +
                ", carIdList=" + cars +
                '}';
    }
}
