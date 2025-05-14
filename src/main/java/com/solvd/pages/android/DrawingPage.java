package com.solvd.pages.android;

import com.solvd.pages.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IMobileUtils {

    @ExtendedFindBy(image = "drawn_line.png")
    private ExtendedWebElement drawnLine;

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void drawLine() {
        pause(2);
        double x = getDriver().manage().window().getSize().getWidth() * 0.5;
        double y = getDriver().manage().window().getSize().getHeight() * 0.5;
        swipe((int) (x), (int) (y - 400), (int) (x), (int) (y - 600), 500);
    }

    @Override
    public boolean isHorizontalLinePresent() {
        return drawnLine.isElementPresent();
    }
}
