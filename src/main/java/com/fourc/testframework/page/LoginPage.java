package com.fourc.testframework.page;

import com.fourc.testframework.helper.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage  {

    private static final By EMAIL_INPUT = Locators.get("LoginPage.EmailInput");
    private static final By PASSWORD_INPUT = Locators.get("LoginPage.PasswordInput");
    private static final By SIGNIN_BTN = Locators.get("LoginPage.SignInBtn");


    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage login(String login, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(login);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(SIGNIN_BTN).click();
        return new MainPage(driver);
    }

}
