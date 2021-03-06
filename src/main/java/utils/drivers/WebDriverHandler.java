package utils.drivers;

import org.openqa.selenium.WebDriver;
import utils.fileUtils.PropertiesFileOperator;

import java.net.MalformedURLException;

public class WebDriverHandler {

    public static WebDriver getWebDriverHost() throws MalformedURLException {
        WebDriverFactory webDriverFactory;
        WebDriver driver;
        String host = PropertiesFileOperator.getHostName();
        if (host.contains("localHost")) {
            webDriverFactory = new LocalWebDriverFactory();
            driver = webDriverFactory.getWebDriver();
        } else {
            webDriverFactory = new RemoteWebDriverFactory();
            driver = webDriverFactory.getWebDriver();
        }
        return driver;
    }
}



