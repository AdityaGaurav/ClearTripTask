package com.cleartrip.retruntrip.experimentTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Implicitwait {

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getPageSource().contains("Selenium"));
        Dimension dimension = driver.manage().window().getSize();
        System.out.println(dimension.getHeight());
        System.out.println(dimension.getWidth());
        driver.manage().window().maximize();
        System.out.println("--"+dimension.getHeight());
        System.out.println("--"+dimension.getWidth());
        Point point = driver.manage().window().getPosition();
        System.out.println(point.getX());
        System.out.println(point.getY());
        driver.findElement(By.xpath("//asd"));
    }
}
