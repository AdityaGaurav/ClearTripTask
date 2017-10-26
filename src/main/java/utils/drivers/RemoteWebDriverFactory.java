package utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class handles the grid setup. Currently it is an empty class.
 **/
class RemoteWebDriverFactory implements WebDriverFactory {
    public WebDriver getWebDriver() throws MalformedURLException {
        URL hub = new URL("");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        WebDriver browserDriver = new RemoteWebDriver(hub, capabilities);
//        ((RemoteWebDriver) browserDriver).setFileDetector(new LocalFileDetector());
//        RemoteWebDriver browserDriver = new RemoteWebDriver(hub, capabilities);
//        browserDriver.setFileDetector(new LocalFileDetector());
        return browserDriver;
//        if (element instanceof RemoteWebElement) {
//            ((RemoteWebElement) element)
//                    .setFileDetector(new LocalFileDetector());
//        } else {
//            throw new IllegalArgumentException(
//                    "Expected argument of type RemoteWebElement, received "
//                            + element.getClass().getName());
//        }
    }

}
