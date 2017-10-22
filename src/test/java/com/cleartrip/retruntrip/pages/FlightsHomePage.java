package com.cleartrip.retruntrip.pages;

import com.cleartrip.retruntrip.locators.FlightsHomePageLocator;
import org.openqa.selenium.By;
import utils.uiutils.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class FlightsHomePage {
    private static long DEFAULT_TIME_OUT_IN_SECONDS = 60;

    public FlightResultPage bookFlight(String tripType, String fromCityNameWithCountryCode, String toCityNameWithCountryCode, String depDate,
                                       String returnDate, String adultValue, String childrenValue, String infantsValue) throws ParseException {
        selectTripType(tripType);
        selectFromCity(fromCityNameWithCountryCode);
        selectToCity(toCityNameWithCountryCode);
        selectDateInCalendar(depDate);
        selectDateInCalendar(returnDate);
        selectAdultDropDown(adultValue);
        selectChildrenDropDown(childrenValue);
        selectInfantDropDown(infantsValue);
        return clickOnSubmitButton();
    }

    private void selectTripType(String tripType) {
        switch (tripType) {
            case "OneTrip":
                selectOneWayTrip();
                break;
            case "RoundTrip":
                selectRoundTrip();
                break;
            case "Multicity":
                selectMultiCityTrip();
                break;
            default:
                System.out.print("Your option is not listed down here");
                break;
        }
    }

    private void selectRoundTrip() {
        RadioButton.selectRadioButtonByGivenLocator(FlightsHomePageLocator.ROUND_TRIP_RADIO_BUTTON);
    }

    private void selectOneWayTrip() {
        RadioButton.selectRadioButtonByGivenLocator(FlightsHomePageLocator.ONE_WAY_TRIP_RADIO_BUTTON);
    }

    private void selectMultiCityTrip() {
        RadioButton.selectRadioButtonByGivenLocator(FlightsHomePageLocator.MULTI_CITY_TRIP_RADIO_BUTTON);
    }

    private void selectFromCity(String cityName) {
        FindElement.sendTextToElement(FlightsHomePageLocator.FROM_TEXT_BOX, cityName, DEFAULT_TIME_OUT_IN_SECONDS);
        selectAutoSuggestOption(cityName);
    }

    private void selectToCity(String cityName) {
        FindElement.sendTextToElement(FlightsHomePageLocator.TO_TEXT_BOX, cityName, DEFAULT_TIME_OUT_IN_SECONDS);
        selectAutoSuggestOption(cityName);
    }

    private void selectDateInCalendar(String depDate) throws ParseException {
        if(!checkForCurrentDates(depDate)){
            throw new RuntimeException(depDate + " should be either equal to current date or greater than");
        }
        String[] fromDate = UIUtils.splitString(depDate, "/");
        String _year = fromDate[0];
        String _month = fromDate[1];
        String _date = fromDate[2];
        By yearCalendar = FlightsHomePageLocator.YEAR_LOC;
        By monthCalendar = FlightsHomePageLocator.MONTH_Loc;
        By dateCalendar = FlightsHomePageLocator.getCalendarDateLocator(_date, _month, _year);
        By nextButton = FlightsHomePageLocator.NEXT_DATA_HANDLER;
        CalendarDatePicker.selectDateFromCalendar(depDate, yearCalendar, nextButton, monthCalendar, dateCalendar);
    }

    private void selectAdultDropDown(String dropDownValue) {
        DropDown.selectDropDownByValue(dropDownValue, FlightsHomePageLocator.ADULT_DROP_DOWN);
    }

    private void selectChildrenDropDown(String dropDownValue) {
        DropDown.selectDropDownByValue(dropDownValue, FlightsHomePageLocator.CHILDREN_DROP_DOWN);
    }


    private void selectInfantDropDown(String dropDownValue) {
        DropDown.selectDropDownByValue(dropDownValue, FlightsHomePageLocator.INFANTS_DROP_DOWN);
    }

    private FlightResultPage clickOnSubmitButton() {
        FindElement.clickOnWebElement(FlightsHomePageLocator.SEARCH_FLIGHT_BUTTON, DEFAULT_TIME_OUT_IN_SECONDS);
        return new FlightResultPage();
    }

    public static void selectAutoSuggestOption(String cityNameWithCountryCode) {
        FindElement.clickOnWebElement(FlightsHomePageLocator.getAutoComplete(cityNameWithCountryCode), DEFAULT_TIME_OUT_IN_SECONDS);
    }

    private boolean checkForCurrentDates(String inputDate) throws ParseException {
        boolean result = false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = sdf.parse(dtf.format(localDate));
        Date date2 = sdf.parse(inputDate);
        if (date1.compareTo(date2) > 0) {
            result = false;
        } else if (date1.compareTo(date2) < 0) {
            result = true;
        } else if (date1.compareTo(date2) == 0) {
            result = true;
        }
        return result;
    }
}
