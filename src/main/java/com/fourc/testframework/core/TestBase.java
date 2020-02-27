package com.fourc.testframework.core;

import com.fourc.testframework.webdriver.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    private String DEFAULT_URL = "https://www.indeed.com";
    public static WebDriver driver;

    @BeforeMethod
    public void setup() {
            driver = WebDriverConfiguration.setLocalDriver();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
            driver.get(DEFAULT_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
