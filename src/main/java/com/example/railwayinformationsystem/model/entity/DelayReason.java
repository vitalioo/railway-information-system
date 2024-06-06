package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "delay_reason")
public class DelayReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delay_reason_id", nullable = false)
    private Integer id;

    @Column(name = "reason", nullable = false)
    private String reason;
}
