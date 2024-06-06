package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locomotive_id")
    private Locomotive locomotive;

    @Column(name = "train_type", nullable = false)
    private String trainType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "delay_reason_id")
    private List<DelayReason> delayReason = new ArrayList<>();

    @Column(name = "tickets_returned")
    private Short ticketsReturned;

}