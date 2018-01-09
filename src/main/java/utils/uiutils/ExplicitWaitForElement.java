package utils.uiutils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ExplicitWaitForElement extends UIUtils {

    public void explicitlyWaitForElement(By loc) {
        Wait<WebDriver> wait = new FluentWait<>(threadLocal.get())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("The message you will see If TimeOut Exception is thrown");
        WebDriver driver = wait.until(new ExpectedCondition<WebDriver>() {
            @Override
            public WebDriver apply(WebDriver input) {
                return null;
            }
        });
    }

    public boolean explicitlyWaitForElements(By loc) {
        Wait<WebDriver> wait = new FluentWait<>(threadLocal.get())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("The message you will see If TimeOut Exception is thrown");
        return wait.until(webDriver -> webDriver.findElement(loc).isDisplayed());
//       return wait.until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver input) {
//                return null;
//            }
//        });
//        return wait.until(webDriver -> webDriver.findElement(loc).isDisplayed());
    }

    public boolean waitTillAllElementGetDisplayed(By loc) {
        Wait<WebDriver> wait = new FluentWait<>(threadLocal.get())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("The message you will see If TimeOut Exception is thrown");
        return wait.until(new Function<WebDriver, Boolean>() {
                              public Boolean apply(WebDriver driver) {
                                  List<WebElement> allEle = driver.findElements(By.name("foo"));
                                  List<String> allText = new ArrayList<>();
                                  for (WebElement e : allEle) {
                                      String textEle = e.getText();
                                      if (textEle.equals("SomeData"))
                                          allText.add(textEle);
                                      if (allText.size() == 10) {
                                          return true;
                                      }
                                  }
                                  return false;
                              }
                          }
        );

    }

    public List<WebElement> waitTillAllCountElementGetDisplayed(By loc) {
        Wait<WebDriver> wait = new FluentWait<>(threadLocal.get())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("The message you will see If TimeOut Exception is thrown");
        return wait.until(ExpectedConditions.numberOfElementsToBe(loc, webDriver.findElements(loc).size()));
    }

}