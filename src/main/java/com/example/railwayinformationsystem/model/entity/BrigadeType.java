package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "brigade_type")
public class BrigadeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brigade_type_id", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false)
    private String type;

}