package com.example.herokuapp.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Guy {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private Double percentage;
}
