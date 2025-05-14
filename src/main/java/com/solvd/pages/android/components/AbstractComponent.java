package com.solvd.pages.android.components;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class AbstractComponent extends AbstractUIObject implements IMobileUtils {
    public AbstractComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
