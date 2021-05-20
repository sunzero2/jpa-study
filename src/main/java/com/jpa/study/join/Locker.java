package com.jpa.study.join;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "LOCKER")
@Data
public class Locker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
