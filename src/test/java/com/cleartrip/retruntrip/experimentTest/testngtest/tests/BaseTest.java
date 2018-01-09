package com.cleartrip.retruntrip.experimentTest.testngtest.tests;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeGroups(groups = {"sanity"})
    public void setUPBeforeGroups(ITestContext iTestResult) {
        System.out.println(iTestResult.getName()+"BeforeGroups");
    }

    @BeforeClass(groups = "sanity")
    public void setUPBeforeClass(ITestContext iTestResult) {
        System.out.println(iTestResult.getName()+"BeforeClass");
    }

    @BeforeSuite
    public void setUPBeforeSuite(ITestContext iTestResult) {
        System.out.println(iTestResult.getName()+"BeforeSuite");
    }

    @BeforeTest
    public void setUPBeforeTest(ITestContext iTestResult) {
        System.out.println(iTestResult.getName()+"BeforeTest");
    }

    @BeforeMethod
    public void setUPBeforeMethod(ITestContext iTestResult) {
        System.out.println(iTestResult.getName()+"BeforeMethod");
    }

    @AfterClass
    public void tearDownAfterClass(ITestContext iTestResult) {
        System.out.println(iTestResult.getName()+"AfterClass");
    }

    @AfterSuite
    public void tearDownAfterSuite(ITestContext iTestResult) {
        System.out.println(iTestResult.getName()+"AfterSuite");
    }

    @AfterTest
    public void tearDownAfterTest(ITestContext iTestResult) {
        System.out.println(iTestResult.getName()+"AfterTest");
    }

    @AfterMethod
    public void tearDownAfterMethod(ITestResult iTestResult) {
        System.out.println(iTestResult.getMethod().getMethodName()+"AfterMethod");
    }

    @AfterGroups
    public void tearDownAfterGroups(ITestContext iTestResult) {
        System.out.println(iTestResult.getName()+"AfterGroups");
    }

}
