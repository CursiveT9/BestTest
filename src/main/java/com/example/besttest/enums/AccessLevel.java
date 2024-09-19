package com.example.besttest.enums;

public enum AccessLevel {
    OPEN(1),
    RESTRICTED(2),
    PRIVATE(3);

    private final int accessLevelTypeCode;

    private AccessLevel(int accessLevelTypeCode) {
        this.accessLevelTypeCode = accessLevelTypeCode;
    }

    public int getAccessLevelTypeCode() {
        return accessLevelTypeCode;
    }
}
