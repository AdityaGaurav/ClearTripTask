package utils.basepage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.drivers.WebDriverHandler;
import utils.fileUtils.PropertiesFileOperator;
import utils.uiutils.UIUtils;

import java.net.MalformedURLException;


public class BasePage {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    @BeforeMethod(alwaysRun = true)
    protected void setBrowser() throws MalformedURLException {
        webDriver.set(WebDriverHandler.getWebDriverHost());
    }

    @BeforeMethod(dependsOnMethods = "setBrowser")
    protected void setConfiguration() {
        try {
            final String URL = PropertiesFileOperator.getURLName();
            if (webDriver.get() != null) {
                UIUtils.setWebDriver(webDriver.get());
                UIUtils.openURL(URL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        if (webDriver.get() != null)
            webDriver.get().quit();
    }
}
