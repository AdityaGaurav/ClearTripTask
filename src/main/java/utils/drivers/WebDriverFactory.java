package utils.drivers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

interface WebDriverFactory {
    WebDriver getWebDriver() throws MalformedURLException;

}
