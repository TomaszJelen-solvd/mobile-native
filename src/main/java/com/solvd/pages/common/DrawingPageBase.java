package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends PageBase {

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void drawLine();

    public abstract boolean isHorizontalLinePresent();
}
