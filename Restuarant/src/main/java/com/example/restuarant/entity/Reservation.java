package com.example.restuarant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservationId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "host_first_name")
    private String hostFirstName;

    @Column(name = "host_last_name")
    private String hostLastName;

    @Column(name = "date_requested")
    private Timestamp date_requested;

    @Column(name = "date_reserved")
    private Timestamp dateReserved;

    @Column(name = "active")
    private Integer active;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

}
