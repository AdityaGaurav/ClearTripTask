package utils.uiutils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIUtils {

    static WebDriver webDriver;

    UIUtils() {
    }

    public UIUtils(WebDriver driver) {
        webDriver = driver;
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver = driver;
    }

    public boolean isValidLocator(By loc) {
        boolean flag = false;
        if (webDriver.findElements(loc).size() > 0) {
            flag = true;
        }
        return flag;
    }

    public static String[] splitString(String input, String regex) {
        return input.split(regex);
    }

    public static void openURL( String url) throws Exception {
        if (url != null || url.trim().length() != 0) {
            System.out.println("Given url inside method: " + url);
            webDriver.get(url);
        } else {
            throw new Exception(url + " is not a valid selector");
//            System.out.println("Not A valid URL.");
        }
    }

    public static String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }
}
