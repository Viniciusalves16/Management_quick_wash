package com.example.management.enumeration;

import lombok.Getter;

@Getter
public enum RoleType {

    NORMAL(1, "Normal User "),
    SIMPLE_USER(2, "Simple User "),
    ADMIN(3, "Administrator");

    private final int roleId;
    private final String description;

    RoleType(int roleId, String description) {
        this.roleId = roleId;
        this.description = description;
    }

}
