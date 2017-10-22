package utils.uiutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDatePicker extends UIUtils {

    public static void selectDateFromCalendar(String from, By yearLoc, By nextButtonLoc, By monthLoc, By dateLoc) {
        String[] fromDate = UIUtils.splitString(from, "/");
        String year = fromDate[0];
        String month = fromDate[1];
        String date = fromDate[2];
        String monthName = getMonthNameFromInt(Integer.valueOf(month));
        WebElement yearElement = FindElement.findElementOnPage(yearLoc,30);
        String currentYear = yearElement.getText();
        if (!currentYear.equalsIgnoreCase(year)) {
            while (!currentYear.equalsIgnoreCase(year)) {
                WebElement nextButton = FindElement.findElementOnPage(nextButtonLoc, 30);
                nextButton.click();
                WebElement nextYear = webDriver.findElement(yearLoc);
                currentYear = nextYear.getText();
            }
        }
        WebElement monthElement = FindElement.findElementOnPage(monthLoc, 20);
        String currentMonth = monthElement.getText();
        if (!currentMonth.equalsIgnoreCase(monthName)) {
            while (!currentMonth.equalsIgnoreCase(monthName)) {
                WebElement nextButton = webDriver.findElement(nextButtonLoc);
                nextButton.click();
                WebElement nextMonth = webDriver.findElement(monthLoc);
                currentMonth = nextMonth.getText();
            }
        }
        WebElement dateElement = FindElement.findElementOnPage(dateLoc, 30);
        dateElement.click();
    }

    public static int getMonthInInt(String month) throws ParseException {
        Date date = new SimpleDateFormat("MMMM").parse(month);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    public static String getMonthNameFromInt(int month) {
        String monthName = new DateFormatSymbols().getMonths()[month - 1];
        return monthName;
    }
}
