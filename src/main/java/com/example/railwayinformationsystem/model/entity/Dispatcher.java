package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dispatcher")
public class Dispatcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dispatcher_id", nullable = false)
    private Integer id;

    @Column(name = "working_sector", nullable = false)
    private String workingSector;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    private Worker worker; //oop nasledovanie

}