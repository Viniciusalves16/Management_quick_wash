package com.example.management.enumeration;

import lombok.Getter;

@Getter
public enum RoleType {

    BASIC(1, "Basic User"),
    ADMIN(2, "Administrator");

    private final int roleId;
    private final String description;

    RoleType(int roleId, String description) {
        this.roleId = roleId;
        this.description = description;
    }

}
