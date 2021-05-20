package com.jpa.study.join;

import lombok.Data;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Data
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private int id;

    private String name;

    @ManyToMany(mappedBy = "products")
    private List<Member> members;
}
