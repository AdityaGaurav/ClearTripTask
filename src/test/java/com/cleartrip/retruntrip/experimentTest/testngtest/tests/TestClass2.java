package com.cleartrip.retruntrip.experimentTest.testngtest.tests;

import org.testng.ITestContext;
import org.testng.annotations.Test;

@Test(enabled =false)
public class TestClass2 extends BaseTest {
    @Test
    public void m1_TestClass2(ITestContext iTestContext) {
        System.out.println(iTestContext.getName());
    }

    @Test
    public void m2_TestClass2(ITestContext iTestContext) {
        System.out.println(iTestContext.getName());
    }

    @Test
    public void m3_TestClass2(ITestContext iTestContext) {
        System.out.println(iTestContext.getName());
    }
}
