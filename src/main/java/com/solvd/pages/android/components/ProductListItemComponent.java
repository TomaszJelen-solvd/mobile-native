package com.solvd.pages.android.components;

import com.zebrunner.carina.utils.android.AndroidService;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductListItemComponent extends AbstractUIObject{
    @AndroidFindBy(accessibility = "test-Item title")
    private ExtendedWebElement title;

    @AndroidFindBy(accessibility = "test-Price")
    private ExtendedWebElement price;

    @AndroidFindBy(accessibility = "test-Item description")
    private ExtendedWebElement description;

    @AndroidFindBy(accessibility = "test-ADD TO CART")
    private ExtendedWebElement addButton;

    @AndroidFindBy(accessibility = "test-REMOVE")
    private ExtendedWebElement removeButton;

    public ProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle() {
        new AndroidService().swipe(title);
        return title.getText();
    }

    public String getPrice() {
        new AndroidService().swipe(price);
        return price.getText();
    }

    public boolean isDescriptionPresent() {
        return description.isElementPresent();
    }

    public void addProduct() {
        new AndroidService().swipe(addButton);
        addButton.click();
    }

    public void removeProduct() {
        new AndroidService().swipe(removeButton);
        removeButton.click();
    }
}
