package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id", nullable = false)
    private Integer id;

    @Column(name = "route_type", nullable = false, length = 30)
    private String routeType;

    @Column(name = "duration_seconds")
    private BigInteger durationSeconds;

    @Column(name = "initial_destination", nullable = false)
    private String initialDestination;

    @Column(name = "final_destination", nullable = false)
    private String finalDestination;

    @Column(name = "canceled")
    private Boolean canceled;

    /*@OneToMany(mappedBy = "route")
    private Set<RouteStation> routeStations = new HashSet<>(); //todo???

    @OneToMany(mappedBy = "route")
    private Set<Ticket> tickets = new HashSet<>(); //todo???*/

}