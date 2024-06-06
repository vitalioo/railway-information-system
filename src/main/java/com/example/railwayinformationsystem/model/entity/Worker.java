package com.example.railwayinformationsystem.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brigade_id", nullable = false)
    private Brigade brigade;

    @Column(name = "work_experience", nullable = false)
    private Short workExperience;

    @Column(name = "gender", nullable = false, length = 1)
    private Character gender;

    @Column(name = "age", nullable = false)
    private Short age;

    @Column(name = "children_count", nullable = false)
    private Short childrenCount;

    @Column(name = "salary", nullable = false)
    private Integer salary;

}