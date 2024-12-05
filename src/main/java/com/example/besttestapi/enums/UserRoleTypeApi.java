package com.example.besttestapi.enums;

public enum UserRoleTypeApi {
    USER(1),
    CREATOR(2),
    ADMIN(3);

    private final int userRoleTypeCode;

    private UserRoleTypeApi(int userRoleTypeCode) {
        this.userRoleTypeCode = userRoleTypeCode;
    }

    public int getUserRoleTypeCode() {
        return userRoleTypeCode;
    }
}
