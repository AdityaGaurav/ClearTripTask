package com.cleartrip.retruntrip.experimentTest.testngtest.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.jetty9.servlets.DataRateLimitedServlet;
import org.testng.ITestContext;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class TestClass extends BaseTest {
    private String browserName;
    private String platformName;

    @Parameters({"browserName", "platformName"})
    TestClass(@Optional("chrome") String browserName, @Optional("windows") String platformName) {
        this.browserName = browserName;
        this.platformName = platformName;
    }

    @Test(groups = {"sanity", "regression", "windows"})
    @Parameters({"browserName", "platformName"})
    public void m1_TestClass(String browserName, String platform, ITestContext iTestContext) {
        System.out.println(iTestContext.getName());
        System.out.println(this.browserName);
        System.out.println(this.platformName);
    }

    @Test(groups = {"sanity", "regression"})
    public void m2_TestClass(ITestContext iTestContext) {
        System.out.println(iTestContext.getName());
    }

    @Test(groups = {"sanity"})
    public void m3_TestClass(ITestContext iTestContext) {
        System.out.println(iTestContext.getName());
    }

    WebDriver driver = new FirefoxDriver();
    void testPageNumber(String url, int totalNumberOfPages, long expectePageLoadTimeOut) {
        if (url == null || url.trim().length() == 0) {
            throw new IllegalArgumentException("Not a valid url");
        }
        if (totalNumberOfPages <= 0) {

        }
        try {
             driver = new FirefoxDriver();
            driver.get(url);
            SoftAssert softAssert = new SoftAssert();
            for (int i = 0; i <= totalNumberOfPages; i++) {
                String actualPageNumber = driver.findElement(By.id("page-" + i)).getText();
                softAssert.assertEquals(actualPageNumber, i, "Expected page number is " + i + "Found" + actualPageNumber);
                driver.findElement(By.id("next")).click();
                driver.manage().timeouts().pageLoadTimeout(expectePageLoadTimeOut, TimeUnit.SECONDS);
            }
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(driver != null){
                driver.quit();
            }
        }
    }

}
