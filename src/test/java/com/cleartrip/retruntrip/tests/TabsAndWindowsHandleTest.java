package com.cleartrip.retruntrip.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.*;

public class TabsAndWindowsHandleTest {
    WebDriver driver;
    String URL;

    @BeforeTest
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
//        return driver;
    }

    @Test
    public void TestTabsAndFrames() throws InterruptedException {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Try it Yourself »"))));
        element.click();
        List<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        WebDriverWait waitFrame = new WebDriverWait(driver, 10);
        waitFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
        WebDriverWait waitChildFrame = new WebDriverWait(driver, 10);
        int size2 = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size2);
        waitChildFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='https://www.w3schools.com']")));
        driver.findElement(By.linkText("HTML REFERENCE")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[contains(text(),'Run')]")).click();
//        driver.close();
        driver.switchTo().window(tabs2.get(0));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Try it Yourself »"))));
        element.click();
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        for (String str : tabs) {
            System.out.println(str);
            driver.switchTo().window(str);
            Thread.sleep(3000);
        }
    }


    @Test
    public void getListOfBrowserSupportedIFrame() {
        ArrayList<String> browserName = new ArrayList<>();
        ArrayList<String> isSupport = new ArrayList<>();
        Map<ArrayList<String>, ArrayList<String>> listOfBrowser = new LinkedHashMap<>();
        driver.get("https://www.w3schools.com/tags/tag_iframe.asp");
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='browserref notranslate']//th")));
        List<WebElement> list = driver.findElements(By.xpath("//table[@class='browserref notranslate']//th"));
        for (int i = 2; i <= list.size(); i++) {
            String loc = "//table[@class='browserref notranslate']//th[" + i + "]";
            WebElement elements = driver.findElement(By.xpath(loc));
            browserName.add(elements.getAttribute("title"));
        }
        List<WebElement> list2 = driver.findElements(By.xpath("//table[@class='browserref notranslate']//td"));
        for (int i = 2; i <= list2.size(); i++) {
            String loc = "//table[@class='browserref notranslate']//td[" + i + "]";
            WebElement elements = driver.findElement(By.xpath(loc));
            isSupport.add(elements.getText());
        }
        Assert.assertEquals(browserName.size(), isSupport.size(), "Count is not same");
        listOfBrowser.put(browserName, isSupport);
        int i = 0;
        for (ArrayList<String> name : listOfBrowser.keySet()) {
            for (String str : name) {
                System.out.println("Name of Browser" + name + "" + listOfBrowser.get(name).get(i));
                i++;
            }
        }
    }

    @AfterTest
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
