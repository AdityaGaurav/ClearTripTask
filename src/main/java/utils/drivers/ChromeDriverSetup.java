package utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class ChromeDriverSetup extends LocalWebDriverFactory {

    private WebDriver setChromeWebDriver() {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", chromeBinaryPath);
        // or Using ChromeDriverService class for this.
//        ChromeDriverService chromeDriverServices = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File(chromeBinaryPath)).usingAnyFreePort().build();
        // driver = new ChromeDriver(chromeDriverServices,capability);
        driver = new ChromeDriver(capability);
        return driver;
    }

    // -- chrome://version --/
    static class ChromeDriverProfileSetup {
        String profilePath = "C:\\Users\\adityag\\AppData\\Local\\Google\\Chrome\\User Data\\Default";

        void setChromeProfile() {
            ChromeOptions chOption = new ChromeOptions();
            chOption.addArguments("user-data-dir=ChromeProfile Location");
        }
    }
}
