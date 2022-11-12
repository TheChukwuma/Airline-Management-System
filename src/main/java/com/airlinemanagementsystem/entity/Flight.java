package com.airlinemanagementsystem.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "flights")
public class Flight extends BaseClass{
    private Long flightNo;
    private String carrierName;
    private String flightModel;
    private Integer seatCapacity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Flight flight = (Flight) o;
        return getId() != null && Objects.equals(getId(), flight.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
