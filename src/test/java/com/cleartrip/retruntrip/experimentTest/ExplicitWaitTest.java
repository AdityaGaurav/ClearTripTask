package com.cleartrip.retruntrip.experimentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;

public class ExplicitWaitTest {
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
        WebElement element = driver.findElement(By.xpath(""));
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        String[][] input = new String[2][];
        input[0] = new String[]{"A", "B"};
        input[1] = new String[]{"A", "B"};
        for (String[] str : input) {
            for (String i : str) {
                System.out.println(i.toLowerCase());
            }
        }
    }
}
