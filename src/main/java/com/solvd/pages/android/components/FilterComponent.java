package com.solvd.pages.android.components;

import com.solvd.pages.SortType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterComponent extends AbstractUIObject{
    @FindBy(xpath = "//android.widget.TextView[@text='Price (low to high)']")
    private ExtendedWebElement sortAscendingOption;

    @FindBy(xpath = "//android.widget.TextView[@text='Price (high to low)']")
    private ExtendedWebElement sortDescendingOption;
    public FilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void sortPrices(SortType sortType) {
        if (sortType.isAscending()) {
            sortAscendingOption.click();
        } else {
            sortDescendingOption.click();
        }
    }
}
