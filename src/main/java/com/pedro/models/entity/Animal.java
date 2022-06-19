package com.pedro.models.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "animals")
public class Animal extends PanacheEntity {
    private String name;

    private String type;

    private String sex;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
}
