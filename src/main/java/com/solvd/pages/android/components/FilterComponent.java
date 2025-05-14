package com.solvd.pages.android.components;

import com.solvd.pages.SortType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterComponent extends AbstractComponent {
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
