package utils.uiutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends UIUtils {

    public static void selectDropDownByValue(String value, By dropDownLocId) {
        WebElement element = threadLocal.get().findElement(dropDownLocId);
        Select selectDropDownByValue = new Select(element);
        selectDropDownByValue.selectByValue(value);
    }

    public static void selectDropDownByIndex(int index, By dropDownLocId) {
        WebElement element = threadLocal.get().findElement(dropDownLocId);
        Select selectDropDownByValue = new Select(element);
        selectDropDownByValue.selectByIndex(index);
    }

    public static void seleDropDownByVisibleText(String text, By dropDownLocId) {
        WebElement element = threadLocal.get().findElement(dropDownLocId);
        Select selectDropDownByValue = new Select(element);
        selectDropDownByValue.selectByVisibleText(text);
    }

    public static String getSelectedOption(By dropDownLocId){
        WebElement element = threadLocal.get().findElement(dropDownLocId);
        Select selectDropDownByValue = new Select(element);
        selectDropDownByValue.getOptions();
        selectDropDownByValue.getAllSelectedOptions();
         String result = "";
        return result;
    }
}
