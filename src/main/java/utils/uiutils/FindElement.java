package utils.uiutils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElement extends WaitForElement {

    public static WebElement findElementOnPage(By elementLocToFind, long unit) {
        WebElement element = null;
        try {
            waitForElementTillVisibility(elementLocToFind, unit);
            element = threadLocal.get().findElement(elementLocToFind);
        } catch (NoSuchElementException e) {
            threadLocal.get().findElement(elementLocToFind);
        }
        return element;
    }

    public static void clickOnWebElement(By elementLoc,long unit) {
        waitForElementToBeClickable(elementLoc,unit);
        findElementOnPage(elementLoc,unit).click();
    }

    public static void sendTextToElement(By element, String textToSend,long unit) {
        findElementOnPage(element,unit).clear();
        findElementOnPage(element,unit).sendKeys(textToSend);
    }
    public static List<WebElement> findElementsOnPage(By elementLocToFind,long unit) {
        waitForVisibilityOfAllElementsLocatedBy(elementLocToFind,unit);
        return threadLocal.get().findElements(elementLocToFind);
    }

    public static List<WebElement> findElementsOnPageTillAlllElementPresent(By elements, long unit){
        waitForPresenceOfAllElementsLocated(elements, unit);
        return threadLocal.get().findElements(elements);
    }

    public static  List<WebElement> listOFElements(By loc){
        return threadLocal.get().findElements(loc);
    }

    public static WebElement findElement(By loc){
        return threadLocal.get().findElement(loc);
    }

}
