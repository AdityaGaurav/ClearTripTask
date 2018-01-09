package utils.basepage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.drivers.WebDriverHandler;
import utils.fileUtils.PropertiesFileOperator;
import utils.uiutils.UIUtils;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BasePage {

    protected static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private static List<WebDriver> webDriversPool = Collections.synchronizedList(new ArrayList<>());
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    protected void setBrowser() throws MalformedURLException {
        webDriver.set(WebDriverHandler.getWebDriverHost());
    }

    @BeforeMethod(dependsOnMethods = "setBrowser")
    protected void setConfiguration() {
        try {
            final String URL = PropertiesFileOperator.getURLName();
            webDriversPool.add(webDriver.get());
            if (webDriver.get() != null) {
                UIUtils.setWebDriver(webDriver.get());
                UIUtils.openURL(URL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        for (WebDriver driver : webDriversPool) {
            driver.quit();
        }
    }
}
