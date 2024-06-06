package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "railway_station")
public class RailwayStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "railway_station_id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "arrival_time")
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
    private LocalDateTime arrivalTime;

    @Column(name = "departure_time")
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
    private LocalDateTime departureTime;

    @OneToMany(mappedBy = "railwayStation")
    private Set<LocomotiveStation> locomotiveStations = new HashSet<>();

    @OneToMany(mappedBy = "station")
    private Set<RouteStation> routeStations = new HashSet<>();

}