package com.hamitmizrak.seniorfullstack1.utils.roles;

public enum ERole {
    SUPER_ADMIN(1L,"super_admin"),
    ADMIN(2L,"admin"),
    ACCOUNTING(3L,"accounting"),
    WRITER(4L,"writer"),
    USER(5L,"user");

    // Variable
    private final Long key;
    private final String value;

    // Constructor
   private ERole(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    // GETTER
    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
} //end Enum ERole
