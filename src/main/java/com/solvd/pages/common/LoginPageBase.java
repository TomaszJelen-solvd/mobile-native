package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends PageBase {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterName(String name);

    public abstract void enterPassword(String password);

    public abstract ProductListPageBase clickLogin();

    public ProductListPageBase login(String name, String password) {
        enterName(name);
        enterPassword(password);
        return clickLogin();
    }

    public abstract boolean isLoginButtonPresent();

    public abstract boolean isErrorMessagePresent();

    public abstract String getErrorText();


}
