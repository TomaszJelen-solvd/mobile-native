package com.solvd.service;

public enum LoginCredentials {
    STANDARD_USER("standard_user", "secret_sauce"),
    USER_INVALID_CREDENTIALS("aaa", "aaa"),
    USER_LOCKED_OUT_CREDENTIALS("locked_out_user", "secret_sauce");

    private String name;
    private String password;

    LoginCredentials(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
