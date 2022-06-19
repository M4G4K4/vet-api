package com.pedro.models.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User extends PanacheEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "card_identification")
    private String cardIdentification;

    @OneToMany(
        mappedBy = "owner"
    )
    private List<Animal> animals;

    public String getFullName() {
        return this.firstName.trim() + " " + this.lastName.trim();
    }
}
