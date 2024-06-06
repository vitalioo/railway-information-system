package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "repairmen_brigade")
@Getter
@Setter
public class RepairmenBrigade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repairmen_brigade_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brigade_id")
    private Brigade brigade;

    @OneToMany(mappedBy = "repairmenBrigade")
    private Set<Locomotive> locomotives = new HashSet<>();

}
