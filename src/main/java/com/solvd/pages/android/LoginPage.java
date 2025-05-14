package com.solvd.pages.android;

import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @AndroidFindBy(accessibility = "test-Username")
    private ExtendedWebElement username;

    @AndroidFindBy(accessibility = "test-Password")
    private ExtendedWebElement password;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private ExtendedWebElement login;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterName(String name) {
        username.type(name);
    }

    @Override
    public void enterPassword(String password) {
        this.password.type(password);
    }

    @Override
    public ProductListPageBase clickLogin() {
        login.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public boolean isLoginButtonPresent() {
        return login.isElementPresent();
    }

    @Override
    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent();
    }

    @Override
    public String getErrorText() {
        return errorMessage.getText();
    }
}
