package com.solvd.pages.android;

import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase{
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private ExtendedWebElement username;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    private ExtendedWebElement password;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private ExtendedWebElement login;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterName(String name) {
        this.username.type(name);
    }

    @Override
    public void enterPassword(String password) {
        this.password.type(password);
    }

    @Override
    public ProductPageBase clickLogin() {
        login.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public void clickLoginExpectingError() {
        login.click();
    }

    @Override
    public boolean checkIfErrorDisplayed() {
        return errorMessage.isDisplayed();
    }

    @Override
    public String getErrorText() {
        return errorMessage.getText();
    }
}
