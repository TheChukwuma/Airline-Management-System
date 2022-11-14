package com.airlinemanagementsystem.entity;

import com.airlinemanagementsystem.enums.Role;
import com.airlinemanagementsystem.request.AdminRegisterRequest;
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
@DiscriminatorValue("admin")
@Entity
public class Admin extends User{

    private String adminCode;

    public Admin(AdminRegisterRequest request){
        this.adminCode = request.getAdminCode();
        this.setEmail(request.getEmail());
        this.setFirstName(request.getFirstName());
        this.setLastName(request.getLastName());
        this.setPassword(request.getPassword());
        this.setPhoneNumber(request.getPhoneNumber());
        this.setRole(Role.ADMIN);
    }

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
