package com.fourc.testframework.smoke;


import com.fourc.testframework.core.TestBase;
import com.fourc.testframework.helper.Listener;
import com.fourc.testframework.page.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;


@Listeners(Listener.class)
public class MainPageTest extends TestBase {

    public static final String FIND_JOBS_BTN_NAME = "Find Jobs";


    @Title("Verifying What text input is displayed on the Main Page.")
    @Severity(SeverityLevel.CRITICAL)
    @Features("MainPageComponents")
    @TestCaseId("E-1")
    @Story("Story Name: To check What text input")
    @Description("Test Case Description: Verifying What text input is displayed on the Main Page")
    @Test(description = "Verifying What text input is displayed on the Main Page", priority = 1)
    public void verifyTextWhatInputDisplayed() {
        MainPage mainPage = new MainPage(driver);
        boolean whatInputDisplayed = mainPage.isTextWhatInputDisplayed();
        Assert.assertTrue(whatInputDisplayed, "The What text input didn't display!");
    }

    @Title("Verifying Where text input is displayed on the Main Page")
    @Severity(SeverityLevel.CRITICAL)
    @Features("MainPageComponents")
    @TestCaseId("E-2")
    @Story("Story Name: To check Where text input")
    @Description("Test Case Description: Verifying Where text input is displayed on the Main Page")
    @Test(description = "Verifying Where text input is displayed on the Main Page",priority = 2)
    public void verifyTextWhereInputDisplayed() {
        MainPage mainPage = new MainPage(driver);
        boolean whereInputDisplayed = mainPage.isTextWhereInputDisplayed();
        Assert.assertTrue(whereInputDisplayed, "The Where text input didn't display!");
    }


    @Title("Verifying Find Jobs Btn is displayed on the Main Page")
    @Severity(SeverityLevel.CRITICAL)
    @Features("MainPageComponents")
    @TestCaseId("E-3")
    @Story("Story Name: To check Find Jobs Button")
    @Description("Test Case Description: Verifying Find Jobs Btn is displayed on the Main Page")
    @Test(description = "Verifying Find Jobs Btn is displayed on the Main Page",priority = 3)
    public void verifyFindJobsBtnDisplayed() {
        MainPage mainPage = new MainPage(driver);
        boolean findJobsBtnDisplayed = mainPage.isFindJobsBtnDisplayed();
        Assert.assertTrue(findJobsBtnDisplayed, "The Find Jobs Btn didn't display!");
    }

    @Title("Verifying Find Jobs Btn name on the Main Page")
    @Severity(SeverityLevel.CRITICAL)
    @Features("MainPageComponents")
    @TestCaseId("E-4")
    @Story("Story Name: To check Find Jobs Button name")
    @Description("Test Case Description: Verifying Find Jobs Btn name on the Main Page")
    @Test(description = "Verifying Find Jobs Btn name on the Main Page",priority = 4)
    public void verifyFindJobsBtnName() {
        MainPage mainPage = new MainPage(driver);
        String findJobsBtnName = mainPage.getFindJobsBtnName();
        Assert.assertEquals(findJobsBtnName, FIND_JOBS_BTN_NAME,
                String.format("Find Jobs Btna name isn't equal - \"%s\".", FIND_JOBS_BTN_NAME));

    }

}
