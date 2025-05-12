package com.solvd.pages.android.components;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItemComponent extends AbstractUIObject implements IMobileUtils {
    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
    private ExtendedWebElement title;

    public CartItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle() {
        swipe(title);
        return title.getText();
    }
}
