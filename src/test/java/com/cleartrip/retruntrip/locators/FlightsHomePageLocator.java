package com.cleartrip.retruntrip.locators;

import org.openqa.selenium.By;

public class FlightsHomePageLocator {
    public static final By ONE_WAY_TRIP_RADIO_BUTTON = By.id("OneWay");
    public static final By ROUND_TRIP_RADIO_BUTTON = By.id("RoundTrip");
    public static final By MULTI_CITY_TRIP_RADIO_BUTTON = By.id("MultiCity");
    public static final By FROM_TEXT_BOX = By.id("FromTag");
    public static final By TO_TEXT_BOX = By.id("ToTag");
    public static final By MAIN_CALENDAR = By.id("ui-datepicker-div");
    public static final By YEAR_LOC = By.xpath("(//span[@class ='ui-datepicker-year'])[1]");
        public static final By MONTH_Loc = By.xpath("(//span[@class='ui-datepicker-month'])[1]");
    public static final By NEXT_DATA_HANDLER = By.className("nextMonth");
    public static final By ADULT_DROP_DOWN = By.id("Adults");
    public static final By CHILDREN_DROP_DOWN = By.id("Childrens");
    public static final By INFANTS_DROP_DOWN = By.id("Infants");

    public static By getCalendarDateLocator(String date, String month, String year) {
        int monthValue = Integer.valueOf(month);
        return By.xpath("//td[@data-month='" + (monthValue-1) + "'][@data-year='" + year + "']/a[contains(text(),'" + date + "')]");
    }
    public static final By SEARCH_FLIGHT_BUTTON = By.id("SearchBtn");

    public static By getAutoComplete(String cityNameWithCountryCode) {
        String loc =    "//a[starts-with(@id,'ui-id') and contains(text(),'"+cityNameWithCountryCode+"')]";
        return By.xpath(loc);
    }
}