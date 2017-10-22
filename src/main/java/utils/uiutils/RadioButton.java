package utils.uiutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButton extends UIUtils {

    public static void selectRadioButtonByGivenLocator(By expectedRadioButtonLoc) {
        WebElement radiobuttonElement = webDriver.findElement(expectedRadioButtonLoc);
        radiobuttonElement.click();
    }

    public static String getSelectedRadioButton(String name) {
        String nameOfSelectedRadioButton = "";
        By expectedRadioButton = By.name(name);
        List<WebElement> listRadioButton = webDriver.findElements(expectedRadioButton);
        boolean isRadioButtonSelected = false;
        for (WebElement element : listRadioButton) {
            isRadioButtonSelected = element.isSelected();
            if (isRadioButtonSelected) {
                nameOfSelectedRadioButton = element.getText();
                break;
            }
        }
        return nameOfSelectedRadioButton;
    }

    public static void selectRadioButtonByValue(String valueOfExpectedRadioButton, String nameAttibute){
        String radioValue;
        By expectedRadioButton = By.name(nameAttibute);
        List<WebElement> listRadioButton = webDriver.findElements(expectedRadioButton);
        for(WebElement element: listRadioButton){
            radioValue = element.getAttribute("value");
            if(radioValue.contains(valueOfExpectedRadioButton)){
                element.click();
            }
        }
    }


}
