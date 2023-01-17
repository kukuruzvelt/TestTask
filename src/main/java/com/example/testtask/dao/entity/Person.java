package com.example.testtask.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Persons")
@ToString
@Getter
@Setter
public class Person {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String birthday;
}
