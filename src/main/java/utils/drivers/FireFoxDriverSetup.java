package utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FireFoxDriverSetup extends LocalWebDriverFactory {
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

    static class FirFoxDriverProfileSetup {

        void setFireFoxProfile() {
            FirefoxProfile profile = new FirefoxProfile();
//            0  =  Firefox will save all files downloaded via the browser on the user's Desktop.
//            1  =  Downloads are stored in the Downloads folder.
//            2  =  Location specified for the most recent download is utilized again .
            profile.setPreference("browser.download.folderList", 2);
            /*
            Default Value of browser.download.manager.showWhenStarting is true.
            This option means whether or not the Download Manager window is displayed
            when a file download is initiated or not. If we make it as false then Window
            should not be appeared   .
             */
            profile.setPreference("browser.download.manager.showWhenStarting", false);
            // browser. download. dir properties is required for last directory used
            // for saving a file from the "What should (browser) do with this file?"
            profile.setPreference("browser.download.dir", "downloadLocation");
            //This property browser. helperApps. neverAsk. openFile A comma-separated list
            // of MIME types to open directly without asking for confirmation. Default value is an empty string.
            profile.setPreference("browser.helperApps.neverAsk.openFile",
                    "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel," +
                            "image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
            //This property browser. helperApps. neverAsk. saveToDisk A comma-separated list of MIME types to
            // save to disk without asking what to use to open the file. Default value is an empty string.
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                    "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel," +
                            "image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");

        }
    }
}
