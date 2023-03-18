package com.pedro.models.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "card_identification")
    private String cardIdentification;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(
            mappedBy = "owner"
    )
    private List<Animal> animals;

    public String getFullName() {
        return this.firstName.trim() + " " + this.lastName.trim();
    }

    public static Optional<User> findByNif(String nif) {
        return find("nif", nif).firstResultOptional();
    }

    public static Optional<User> findByCardIdentification(String cardIdentification) {
        return find("card_identification", cardIdentification).firstResultOptional();
    }

    public static Optional<User> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }
}
