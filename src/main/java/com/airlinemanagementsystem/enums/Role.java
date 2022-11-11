package com.airlinemanagementsystem.enums;

public enum Role {
    CUSTOMER("Customer"),
    ADMIN("Admin");

    private String display;

    Role(String display) {
        this.display = display;
    }
}
