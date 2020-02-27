package com.fourc.testframework.helper;


import org.apache.commons.io.FileUtils;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import static com.fourc.testframework.core.TestBase.driver;


public class Listener implements ITestListener {

    // image attachments for Allure
    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    private void takeScreenShotInFolder(String name) throws IOException {
        Date now = new Date();
        String path = System.getProperty("user.dir");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(path + "/screenshot/" + name + DateFormat.getInstance().format(now) +
                System.currentTimeMillis() + ".png"));
    }

    public void onTestFailure(ITestResult result) {
        takeScreenshot();
        try {
            takeScreenShotInFolder("failure");
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }


    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
