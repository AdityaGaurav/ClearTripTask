package com.cleartrip.retruntrip.experimentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class RadioAndCheckBoxText {

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
        driver.get("http://demo.guru99.com/selenium/webform/radio.html");
        List<WebElement> radioElements = driver.findElements(By.xpath("//input[@type='radio']"));
        boolean result= false,result2 =false;
        for (WebElement element : radioElements) {
            result = element.isSelected();
            System.out.println(element.getText());
        }
        if (!result) {
            System.out.println("No radio button is selected");
        }
        radioElements.get(1).click();
        result = radioElements.get(1).isSelected();
        if(result){
            System.out.println(radioElements.get(1).getText()+"is selected");
        }
        List<WebElement> checkboxElements = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement element : checkboxElements) {
            result2 = element.isSelected();
            System.out.println(element.getText());
        }
        if (!result2) {
            System.out.println("No Checkbox button is selected");
        }
        checkboxElements.get(1).click();
        result2 = checkboxElements.get(1).isSelected();
        if(result2){
            System.out.println(checkboxElements.get(1).getText()+"is selected");
        }
        Thread.sleep(3000);
        driver.quit();
    }


}
