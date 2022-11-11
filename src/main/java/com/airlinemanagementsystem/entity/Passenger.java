package com.airlinemanagementsystem.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Passenger extends BaseClass{

    @Column(nullable = false,columnDefinition = "VARCHAR(100)")
    private String firstName;

    @Column(nullable = false,columnDefinition = "VARCHAR(100)")
    private String lastName;

    @Column(nullable = false,columnDefinition = "INTEGER")
    private int age;

    @Column(nullable = false,columnDefinition = "VARCHAR(100)")
    private String nationality;

    @Column(nullable = false,columnDefinition = "VARCHAR(100)")
    private String countryOfIssuedPassport; //Country of issuing the document

    @Column(nullable = false,columnDefinition = "VARCHAR(100)")
    private String passportId;

    @Column(nullable = false,columnDefinition = "DATE")
    private Date idExpiryDate;

    @Column(nullable = false ,columnDefinition = "INTEGER")
    private int luggage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Passenger passenger = (Passenger) o;
        return getId() != null && Objects.equals(getId(), passenger.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
