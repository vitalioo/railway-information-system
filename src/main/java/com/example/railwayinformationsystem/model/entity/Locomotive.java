package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "locomotive")
public class Locomotive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locomotive_id", nullable = false)
    private Integer id;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    @Column(name = "name")
    private String name;

    @Column(name = "tickets_count")
    private Integer ticketsCount;

    @OneToMany(mappedBy = "locomotive", fetch = FetchType.EAGER)
    private Set<Maintenance> maintenances = new HashSet<>();

    @OneToMany(mappedBy = "locomotive", fetch = FetchType.LAZY)
    private Set<LocomotiveStation> locomotiveStations = new HashSet<>();

    @OneToMany(mappedBy = "locomotive", fetch = FetchType.LAZY)
    private Set<Schedule> schedules = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brigade_id")
    private Brigade brigade;

    @ManyToOne(fetch = FetchType.EAGER)
    //пофиксило ошибку при запросе по маршруту No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer
    @JoinColumn(name = "repairmen_brigade_id")
    private RepairmenBrigade repairmenBrigade;
}