package com.airlinemanagementsystem.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Column(columnDefinition = "boolean default false")
    private boolean isVerified;
}
