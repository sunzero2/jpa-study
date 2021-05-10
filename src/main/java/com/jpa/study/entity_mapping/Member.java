package com.jpa.study.entity_mapping;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(
//        name = "NAME_AGE_UNIQUE",
//        columnNames = {"NAME", "AGE"}
//)})
@Data
public class Member {
//    @Id
    // 기본키 생성 권한을 데이터베이스에 위임(오라클이면 시퀀스를 사용하고, mysql이면 auto_increment를 사용한다.)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    // nullable = NOT NULL
    // length = (10)
    @Column(name = "NAME", nullable = false, length = 10)
    private String username;

    // Column 어노테이션을 사용하지 않으면 변수명으로 알아서 매핑함
    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;
}
