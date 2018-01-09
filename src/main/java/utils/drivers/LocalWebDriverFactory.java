package utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.fileUtils.PropertiesFileOperator;

import java.io.File;

class LocalWebDriverFactory implements WebDriverFactory {

    private WebDriver driver;
    String firefoxBinaryPath;
    String chromeBinaryPath;

    LocalWebDriverFactory() {
        this.driver = null;
        this.firefoxBinaryPath = "";
        this.chromeBinaryPath = "";
    }

    public WebDriver getWebDriver() {
        return this.setWebDriver();
    }

    private WebDriver setWebDriver() {
        String DEFAULT_BROWSER = "FIREFOX";
        String browserName = PropertiesFileOperator.getBrowserName().toUpperCase();
        if (browserName == null || browserName.trim().length() == 0) {
            browserName = DEFAULT_BROWSER;
        }
        setWebDriverBinariesPath();
        switch (browserName) {
            case "FIREFOX":
                this.driver = setFirefoxWebDriver();
                break;
            case "CHROME":
                this.driver = setChromeWebDriver();
                break;
            default:
                System.out.println("As we didn't get correct request. So by default \"Firefox Driver\" is launching");
                this.driver = setFirefoxWebDriver();
                break;
        }
        return this.driver;
    }

    private void setWebDriverBinariesPath() {
        final String userDirectoryPath = new File(System.getProperty("user.dir")).getAbsolutePath();
        String SEPERATOR = File.separator;
        final String macWebDriverPath = userDirectoryPath + SEPERATOR + "src" + SEPERATOR + "main" + SEPERATOR + "resources" + SEPERATOR + "macWebDrivers" + SEPERATOR;
        final String windowsWebDriverPath = userDirectoryPath + SEPERATOR + "src" + SEPERATOR + "main" + SEPERATOR + "resources" + SEPERATOR + "windowsDriver" + SEPERATOR;
        final String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("mac")) {
            firefoxBinaryPath = macWebDriverPath + SEPERATOR + "geckodriver";
            chromeBinaryPath = macWebDriverPath + SEPERATOR + "chromedriver";
        } else if (osName.toLowerCase().contains("window")) {
            firefoxBinaryPath = windowsWebDriverPath + SEPERATOR + "geckodriver.exe";
            chromeBinaryPath = windowsWebDriverPath + SEPERATOR + "chromedriver.exe";
        } else {
            System.out.println(osName + " is not list down here.");
            //Throw an exception here.
        }
    }

    private WebDriver setFirefoxWebDriver() {
        WebDriver driver;
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver", firefoxBinaryPath);
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("webdriver.gecko.driver", firefoxBinaryPath);
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("dom.webnotifications.enabled", false);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        driver = new FirefoxDriver(profile);
        return driver;
    }

    private WebDriver setChromeWebDriver() {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", chromeBinaryPath);
        driver = new ChromeDriver(capability);
        return driver;
    }
}
