package com.cleartrip.retruntrip.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utils.basepage.BasePage;

import java.io.File;

public class BaseTest extends BasePage {

    @Test
    public void initDriver() {
        final String userDirectoryPath = new File(System.getProperty("user.dir")).getAbsolutePath();
        String SEPERATOR = File.separator;
        final String windowsWebDriverPath = userDirectoryPath + SEPERATOR + "src" + SEPERATOR + "main" + SEPERATOR + "resources" + SEPERATOR + "windowsDriver" + SEPERATOR;
        String chromeBinaryPath = windowsWebDriverPath + SEPERATOR + "chromedriver.exe";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", chromeBinaryPath);
        driver = new ChromeDriver(capability);
        String URL = "https://www.w3schools.com/tags/tag_iframe.asp";
        driver.get(URL);
        driver.findElement(By.xpath("//div/asdefrgthy"));
//        return driver;
    }
}
