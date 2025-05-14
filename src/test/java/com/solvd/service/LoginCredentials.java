package com.solvd.service;

public enum LoginCredentials {
    STANDARD_USER("standard_user", "secret_sauce", null),
    USER_INVALID_CREDENTIALS("aaa", "aaa", "Username and password do not match any user in this service."),
    USER_LOCKED_OUT_CREDENTIALS("locked_out_user", "secret_sauce", "Sorry, this user has been locked out.");

    private String name;
    private String password;
    private String errorText;

    LoginCredentials(String name, String password, String errorText) {
        this.name = name;
        this.password = password;
        this.errorText = errorText;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getErrorText() {
        return errorText;
    }
}
