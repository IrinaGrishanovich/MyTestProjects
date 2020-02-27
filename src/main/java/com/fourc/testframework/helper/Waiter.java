package com.fourc.testframework.helper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    public static WebDriverWait getWaiter(WebDriver driver) {
        return new WebDriverWait(driver, 30);
    }

}
