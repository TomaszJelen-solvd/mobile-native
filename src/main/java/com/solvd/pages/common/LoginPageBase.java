package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends PageBase{
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterName(String name);

    public abstract void enterPassword(String password);

    public abstract ProductPageBase clickLogin();

    public abstract void clickLoginExpectingError();

    public abstract boolean checkIfErrorDisplayed();

    public abstract String getErrorText();


}
