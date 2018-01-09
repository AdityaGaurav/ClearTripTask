package com.cleartrip.retruntrip.experimentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ImpliciWaitTest {
    @Test
    public void negativeTimeOut() {
        String userDirectoryPath = new File(System.getProperty("user.dir")).getAbsolutePath();
        String SEPERATOR = File.separator;
        final String windowsWebDriverPath = userDirectoryPath + SEPERATOR + "src" + SEPERATOR + "main" + SEPERATOR + "resources" + SEPERATOR + "windowsDriver" + SEPERATOR;
        String firefoxBinaryPath = windowsWebDriverPath + SEPERATOR + "geckodriver.exe";
        String chromeBinaryPath = windowsWebDriverPath + SEPERATOR + "chromedriver.exe";
        System.setProperty("webdriver.gecko.driver", firefoxBinaryPath);
        System.setProperty("webdriver.chrome.driver", chromeBinaryPath);
        WebDriver driver = new ChromeDriver(DesiredCapabilities.chrome());
        driver.manage().window().maximize();
        driver.get("http://www.seleniumhq.org/");
        driver.manage().timeouts().implicitlyWait(-1000, TimeUnit.MILLISECONDS);
        boolean isEnabled = driver.findElement(By.xpath("//input[@name='submit']")).isEnabled();
        Assert.assertEquals(isEnabled, true, "Not Enabled");
        driver.quit();
    }
}
