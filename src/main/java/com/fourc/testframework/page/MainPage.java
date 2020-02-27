package com.fourc.testframework.page;


import com.fourc.testframework.helper.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
    private static final By SIGNIN_BTN = Locators.get("MainPage.SignInBtn");
    private static final By USER_ICON = Locators.get("MainPage.UserIcon");
    private static final By USER_ACOUNT_LABEL = Locators.get("MainPage.UserAccountLabel");
    private static final By TEXT_WHAT_INPUT = Locators.get("MainPage.TextWhatInput");
    private static final By TEXT_WHERE_INPUT = Locators.get("MainPage.TextWhereInput");
    private static final By FIND_JOBS_BTN = Locators.get("MainPage.FindJobsBtn");


    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage goToLoginPage() {
        driver.findElement(SIGNIN_BTN).click();
        return new LoginPage(driver);
    }

    public String getUserAccountLabel() {
        driver.findElement(USER_ICON).click();
        return driver.findElement(USER_ACOUNT_LABEL).getText();
    }


    public boolean isUserIconDisplayed() {
        WebElement userIcon;
        try {
            userIcon = driver.findElement(USER_ICON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return userIcon.isDisplayed();
    }


    public boolean isTextWhatInputDisplayed() {
        WebElement textWhatInput;
        try {
            textWhatInput = driver.findElement(TEXT_WHAT_INPUT);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return textWhatInput.isDisplayed();
    }

    public boolean isTextWhereInputDisplayed() {
        WebElement textWhereInput;
        try {
            textWhereInput = driver.findElement(TEXT_WHERE_INPUT);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return textWhereInput.isDisplayed();
    }

    public boolean isFindJobsBtnDisplayed() {
        WebElement findJobsBtn;
        try {
            findJobsBtn = driver.findElement(FIND_JOBS_BTN);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return findJobsBtn.isDisplayed();
    }

    public String getFindJobsBtnName() {
        return driver.findElement(FIND_JOBS_BTN).getText();
    }

    public void clickFindJobsBtn() {
        driver.findElement(FIND_JOBS_BTN).click();
    }


}
