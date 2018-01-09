package com.cleartrip.retruntrip.experimentTest.testngtest.tests;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SampleDataProvider {

    @DataProvider(name = "sampleData")
    public static Object[][] createData(Method method) {
        if(method.getName().equalsIgnoreCase("test")){
            System.out.println("");
            return new Object[][]{
                    {"Aditya", "Gaurav"},
                    {"A", "B"}
            };
        }
        return new Object[][]{
                {"Aditya", "Gaurav"},
                {"A", "B"}
        };
    }

    @DataProvider(name = "remoteServiceDP")
    public Iterator<Object[]> remoteServiceDataProvider(ITestContext ctx, Method method) {
        Collection<Object[]> dp = new ArrayList<Object[]>() {
            {
                add(new Object[]{"http://10.60.1.30/am", true});
                add(new Object[]{"http://10.60.1.30:80/am", true});
                add(new Object[]{"http://10.60.1.30:-1/am", false});
                add(new Object[]{"http://10.60.1.30:80:80/am", false});
            }
        };

        return dp.iterator();
    }

}
