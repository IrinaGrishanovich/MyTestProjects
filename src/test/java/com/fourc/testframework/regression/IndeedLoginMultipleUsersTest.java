package com.fourc.testframework.regression;

import com.fourc.testframework.core.TestBase;
import com.fourc.testframework.helper.Listener;
import com.fourc.testframework.helper.Parser;
import com.fourc.testframework.page.LoginPage;
import com.fourc.testframework.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;


@Features("Login")
@Listeners(Listener.class)
public class IndeedLoginMultipleUsersTest extends TestBase {

    // note: Users' accounts in CSV file are fake. Tests will fail.
    private static final String[] USER_EMAIL_INFO = Parser.getDataFrom(Parser.Parsers.csv);

    @DataProvider(parallel = false)
    public Object[][] userInfoProvider(){
        return new Object[][] {
                new Object[] {USER_EMAIL_INFO[0], USER_EMAIL_INFO[1]},
                new Object[] {USER_EMAIL_INFO[2], USER_EMAIL_INFO[3]},
                new Object[] {USER_EMAIL_INFO[4], USER_EMAIL_INFO[5]},
                new Object[] {USER_EMAIL_INFO[6], USER_EMAIL_INFO[7]},
                new Object[] {USER_EMAIL_INFO[8], USER_EMAIL_INFO[9]}
        };
    }

    @Test(dataProvider = "userInfoProvider")
    public void indeedLoginMultipleUsers(String loginUser, String password){
        MainPage mainPage = new MainPage(driver);

        LoginPage loginPage = mainPage.goToLoginPage();
        mainPage = loginPage.login(loginUser, password);

        boolean userIconDisplayed = mainPage.isUserIconDisplayed();
        Assert.assertTrue(userIconDisplayed, "The User Icon didn't display!");

    }
}
