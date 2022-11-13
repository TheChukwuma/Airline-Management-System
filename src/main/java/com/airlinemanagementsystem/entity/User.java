package com.airlinemanagementsystem.entity;

import com.airlinemanagementsystem.enums.Role;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorColumn(name = "user_type")
@Entity(name = "users")
public class User extends BaseClass{

    @Column(nullable = false,columnDefinition = "VARCHAR(100)")
    private String firstName;

    @Column(nullable = false,columnDefinition = "VARCHAR(100)")
    private String lastName;

    @Column(unique = true, nullable = false,columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String password;

    @Column(nullable = false,columnDefinition = "VARCHAR(100)")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(columnDefinition = "boolean default false")
    private boolean isVerified = false;
}
