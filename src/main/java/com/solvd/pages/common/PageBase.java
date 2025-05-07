package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PageBase extends AbstractPage {

    public PageBase(WebDriver driver) {
        super(driver);
    }
}
