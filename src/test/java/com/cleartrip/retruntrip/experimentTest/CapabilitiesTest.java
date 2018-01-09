package com.cleartrip.retruntrip.experimentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.security.Key;

public class CapabilitiesTest {
    @Test

    public void negativeTimeOut() throws InterruptedException {
        String userDirectoryPath = new File(System.getProperty("user.dir")).getAbsolutePath();
        String SEPERATOR = File.separator;
        final String windowsWebDriverPath = userDirectoryPath + SEPERATOR + "src" + SEPERATOR + "main" + SEPERATOR + "resources" + SEPERATOR + "windowsDriver" + SEPERATOR;
        String firefoxBinaryPath = windowsWebDriverPath + SEPERATOR + "geckodriver.exe";
        String chromeBinaryPath = windowsWebDriverPath + SEPERATOR + "chromedriver.exe";
        System.setProperty("webdriver.gecko.driver", firefoxBinaryPath);
        System.setProperty("webdriver.chrome.driver", chromeBinaryPath);
        Capabilities capabilities = DesiredCapabilities.chrome();
        capabilities.getBrowserName();
        capabilities.getPlatform();
        WebDriver driver = new ChromeDriver(DesiredCapabilities.chrome());
        //driver.get("http://www.seleniumhq.org/download/");
        driver.get("http://www.seleniumhq.org");
        Thread.sleep(3000);
        Actions actions  = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.xpath("//input[@name='submit']"))).click().build().perform();
        Thread.sleep(3000);
        driver.quit();
    }
}