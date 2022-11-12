package com.airlinemanagementsystem.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("admin")
@Entity
public class Admin extends User{

    private String adminCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Admin admin = (Admin) o;
        return getId() != null && Objects.equals(getId(), admin.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
