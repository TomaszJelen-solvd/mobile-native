package com.solvd.pages.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductListItemComponent extends AbstractComponent {
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
        swipe(title);
        return title.getText();
    }

    public String getPrice() {
        swipe(price);
        return price.getText();
    }

    public boolean isProductDescription() {
        return description.isElementPresent();
    }

    public void addProduct() {
        swipe(addButton);
        addButton.click();
    }

    public void removeProduct() {
        swipe(removeButton);
        removeButton.click();
    }
}
