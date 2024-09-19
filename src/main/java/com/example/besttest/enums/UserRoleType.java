package com.example.besttest.enums;

public enum UserRoleType {
    USER(1),
    CREATOR(2),
    ADMIN(3);

    private final int userRoleTypeCode;

    private UserRoleType(int userRoleTypeCode) {
        this.userRoleTypeCode = userRoleTypeCode;
    }

    public int getUserRoleTypeCode() {
        return userRoleTypeCode;
    }
}
