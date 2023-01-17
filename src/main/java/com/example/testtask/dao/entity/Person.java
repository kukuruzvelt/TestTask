package com.example.testtask.dao.entity;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "Persons")
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String birthday;
}
