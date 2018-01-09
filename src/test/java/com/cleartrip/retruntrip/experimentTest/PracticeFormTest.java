package com.cleartrip.retruntrip.experimentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticeFormTest {
    String message = "Always click on the ads display at the right side, this is how we manage the website’s expenses and bring free content for the beginners.";
    WebDriver driver;

    @Test
    public void negativeTimeOut() throws InterruptedException {
        try {
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
            driver = new ChromeDriver(DesiredCapabilities.chrome());
            driver.get("http://toolsqa.com/automation-practice-form/");
            driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.MILLISECONDS);
            String value = driver.findElement(By.xpath("//div[@class='vc_message_box vc_message_box-standard vc_message_box-rounded vc_color-info']/p[2]")).getText();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(value, message, "Not mAtched");
            driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Aditya");
            driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Gaurav");
            WebElement genderElement = driver.findElement(By.xpath("//input[@value='Male']"));
            boolean result = genderElement.isSelected();
            if (!result) {
                genderElement.click();
            }
            List<WebElement> radioElement = driver.findElements(By.xpath("//input[@name='exp']"));
            for (WebElement element : radioElement) {
                String va = element.getAttribute("value");
                if (Integer.parseInt(va) == 4) {
                    element.click();
                    break;
                }
            }

            driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("19-12-2017");

            List<WebElement> professionalList = driver.findElements(By.xpath("//input[@name='profession']"));
            for (WebElement element : professionalList) {
                if (element.getText().equalsIgnoreCase("Automation Tester")) {
                    element.click();
                }
            }
            driver.findElement(By.xpath("//input[@id='photo']")).sendKeys("E:\\AccountManagement\\createAccount.png");

            List<WebElement> toollList = driver.findElements(By.xpath("//input[@name='tool']"));
            for (WebElement element : toollList) {
                if (element.getText().equalsIgnoreCase("Selenium Webdriver")) {
                    element.click();
                }
            }
            WebElement continentDropDown = driver.findElement(By.xpath("//select[@id='continents']"));
            Select select = new Select(continentDropDown);
            select.selectByIndex(6);
            String selectedContinenet = select.getFirstSelectedOption().getText();
            softAssert.assertEquals(selectedContinenet, "Antartica", "Continent is not expected");

            WebElement SeleniumDropDown = driver.findElement(By.xpath("//select[@id='selenium_commands']"));
            Select select2 = new Select(SeleniumDropDown);
            select2.selectByIndex(0);
            select2.selectByVisibleText("Navigation Commands");
            select2.selectByIndex(4);
            List<WebElement> selectedSelenium = select2.getAllSelectedOptions();
            for (WebElement element : selectedSelenium) {
                System.out.println(element.getText());
            }
            driver.findElement(By.xpath("//button")).click();
            Thread.sleep(4000);
            softAssert.assertAll();
            driver.quit();
        } catch (Exception e) {
            driver.quit();
        }
    }
}
