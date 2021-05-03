package com.example.demo.models;

import javax.persistence.*;

@Entity // tells JPA this particular class create table
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(unique = true, columnDefinition = "TEXT") //columdefiniton allows many manuel control
    private String description;

    private int priceIntCents;
}

