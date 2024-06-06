package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "locomotive_station")
public class LocomotiveStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locomotive_station_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "locomotive_id", referencedColumnName = "locomotive_id")
    private Locomotive locomotive;

    @ManyToOne
    @JoinColumn(name = "station_id", referencedColumnName = "railway_station_id")
    private RailwayStation railwayStation;

}