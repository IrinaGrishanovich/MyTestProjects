package com.fourc.testframework.smoke;

import com.fourc.testframework.core.TestBase;
import com.fourc.testframework.helper.Listener;
import com.fourc.testframework.page.LoginPage;
import com.fourc.testframework.page.MainPage;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;


@Listeners(Listener.class)
public class IndeedLoginTest extends TestBase {

    private static final String LOGIN = "grishanovich.iryna@gmail.com";
    private static final String PASSWORD = "Test012345";

    @Title("Verify login into application with correct credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Features("Login")
    @TestCaseId("E-5")
    @Story("Story Name: To check login functionality")
    @Description("Test Case Description: verify login into application with correct credentials")
    @Test(description = "Verify login into application with correct credentials",priority = 1)
    public void checkLoginCorrectCredentials() {
        MainPage mainPage = new MainPage(driver);

        LoginPage loginPage = mainPage.goToLoginPage();
        mainPage = loginPage.login(LOGIN, PASSWORD);

        boolean userIconDisplayed = mainPage.isUserIconDisplayed();
        Assert.assertTrue(userIconDisplayed, "The User Icon didn't display!");

        String userAccountLabel = mainPage.getUserAccountLabel();
        Assert.assertEquals(userAccountLabel, LOGIN,
                String.format("User Account Label isn't equal - \"%s\".", LOGIN));

    }

}
