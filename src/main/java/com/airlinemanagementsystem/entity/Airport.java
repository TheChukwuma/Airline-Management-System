package com.airlinemanagementsystem.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Airport extends BaseClass{
    private String airportCode;
    private String airportLocation;
    private String airportName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Airport airport = (Airport) o;
        return getId() != null && Objects.equals(getId(), airport.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
