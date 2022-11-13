package com.airlinemanagementsystem.entity;

import com.airlinemanagementsystem.enums.Role;
import com.airlinemanagementsystem.request.CustomerRegisterRequest;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@DiscriminatorValue("customer")
@Entity
public class Customer extends User{

    public Customer(CustomerRegisterRequest request){
        this.setEmail(request.getEmail());
        this.setFirstName(request.getFirstName());
        this.setLastName(request.getLastName());
        this.setPassword(request.getPassword());
        this.setPhoneNumber(request.getPhoneNumber());
        this.setRole(Role.CUSTOMER);


    }

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<Booking> booking = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return getId() != null && Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
