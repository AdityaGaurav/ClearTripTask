package com.cleartrip.retruntrip.experimentTest.testngtest.tests;

import org.testng.annotations.Test;

public class DataProviderTest extends BaseTest {

    @Test(dataProvider = "sampleData",dataProviderClass = SampleDataProvider.class)
    public void printData(String fName, String lName){
        System.out.println(fName +" "+lName);
    }

}
