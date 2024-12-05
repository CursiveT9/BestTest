package com.example.besttestapi.enums;

public enum AccessLevelApi {
    OPEN(1),
    PRIVATE(2);

    private final int accessLevelTypeCode;

    private AccessLevelApi(int accessLevelTypeCode) {
        this.accessLevelTypeCode = accessLevelTypeCode;
    }

    public int getAccessLevelTypeCode() {
        return accessLevelTypeCode;
    }
}
