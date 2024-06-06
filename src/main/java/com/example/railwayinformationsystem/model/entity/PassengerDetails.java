package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "passenger_details")
public class PassengerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "passport", nullable = false, length = Integer.MAX_VALUE)
    private String passport;

    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    @Column(name = "age", nullable = false)
    private Short age;

    @Column(name = "baggage", nullable = false)
    private Boolean baggage = false;

    @OneToMany(mappedBy = "passenger")
    private Set<Ticket> tickets = new LinkedHashSet<>();

}