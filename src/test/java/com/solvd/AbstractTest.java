package com.solvd;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

public class AbstractTest implements IAbstractTest {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    WebDriver driver;

    @BeforeMethod(
            alwaysRun = true
    )
    public void beforeMethod() {
        driver = getDriver();
        logger.info("WebDriver created for thread: {}", Thread.currentThread().getId());
    }

}
