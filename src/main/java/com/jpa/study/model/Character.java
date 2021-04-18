package com.jpa.study.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String 
}
