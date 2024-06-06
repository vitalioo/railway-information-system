package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "information_service_worker")
public class InformationServiceWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "information_service_id", nullable = false)
    private Integer id;

    @Column(name = "foreign_languages", nullable = false)
    private String foreignLanguages;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    private Worker worker;

}