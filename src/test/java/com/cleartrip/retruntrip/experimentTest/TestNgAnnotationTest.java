package com.cleartrip.retruntrip.experimentTest;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgAnnotationTest {
    @BeforeGroups(groups = {"sanity"})
    public void setup(){

    }

    @Test(groups = {"sanity","regression"})
    public void setMe(){

    }
}
