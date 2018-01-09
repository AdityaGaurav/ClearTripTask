package utils.uiutils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement extends UIUtils {
    private static byte DEFAULT_TIME_OUT_IN_SECONDS = 60;
    private static Wait waitForElement;

    public static void waitForElementTillVisibility(By locElement, long unit) {
        waitForElement = new WebDriverWait(threadLocal.get(), unit);
        try {
            waitForElement.until(ExpectedConditions.visibilityOfElementLocated(locElement));
        } catch (StaleElementReferenceException e) {
            threadLocal.get().findElement(locElement);
        }
    }

    public static void waitForElementToBeClickable(By locElement, long unit) {
        waitForElement = new WebDriverWait(threadLocal.get(), unit);
        try {
            waitForElement.until(ExpectedConditions.elementToBeClickable(locElement));
        } catch (StaleElementReferenceException e) {
            threadLocal.get().findElement(locElement);
        }
    }

    public static void waitForElementToBe(By elementLocator, long unit) {
        waitForElement = new WebDriverWait(threadLocal.get(), unit);
        try {
            waitForElement.until(ExpectedConditions.elementToBeSelected(elementLocator));
        } catch (StaleElementReferenceException e) {
            threadLocal.get().findElement(elementLocator);
        }
    }

    public static void waitForVisibilityOfAllElementsLocatedBy(By loc, long unit) {
        waitForElement = new WebDriverWait(threadLocal.get(), unit);
        waitForElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
    }

    public static void waitForPresenceOfAllElementsLocated(By loc, long unit){
        waitForElement = new WebDriverWait(threadLocal.get(), unit);
        waitForElement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loc));
    }
}
