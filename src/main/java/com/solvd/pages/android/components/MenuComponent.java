package com.solvd.pages.android.components;

import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class MenuComponent extends AbstractUIObject{
    @AndroidFindBy(accessibility = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    public MenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPageBase logout() {
        logoutButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }
}
