package com.cleartrip.retruntrip.locators;

import org.openqa.selenium.By;

public class FlightResultPageLocator {
//    public static final By PRICE_BUTTON = By.xpath("(//a[@data-sort='price' and contains(text(),'Price')])[1]");
//    public static final By LEFT_SIDE_PRICE_COLUMN = By.xpath("(//nav[@class = 'listViewNav']/ul[@class = 'listView flights'])[1]");
//    public static final By RIGHT_SIDE_PRICE_COLUMN = By.xpath("(//nav[@class = 'listViewNav']/ul[@class = 'listView flights'])[2]");
    public static final By BOOK_BUTTON = By.xpath("(//div[@class ='row roundTripHead']//button[@type= 'submit'])[2]");

    public static By leftSideFlightList() {
        String leftSideFlightList = "(//nav[@class = 'listViewNav']/ul[@class = 'listView flights'])[2]";
        return By.xpath(leftSideFlightList);
    }

    public static By rightSideFlightList() {
        String rightSideFlight = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[3]";
        return By.xpath(rightSideFlight);
    }


    public static By getRadioButton(int index, int tBody, int indexOfFlight) {
        String radiobutton = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[" + index + "]/li[" + indexOfFlight + "]/div[contains(@class,'listItem')]/label/table/tbody[" + tBody + "]/tr//input[@type = 'radio']";
        return By.xpath(radiobutton);
    }

    public static By getDepartTime(int index, int tBody, int indexOfFlight) {
        String departTime = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[" + index + "]/li[" + indexOfFlight + "]/div[contains(@class,'listItem')]/label/table/tbody[" + tBody + "]/tr//th[@class ='depart']";
        return By.xpath(departTime);
    }

    public static By getArrivalTime(int index, int tBody, int indexOfFlight) {
        String arrivalTime = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[" + index + "]/li[" + indexOfFlight + "]/div[contains(@class,'listItem')]/label/table/tbody[" + tBody + "]/tr//th[@class ='arrive' or @class='return']";
        return By.xpath(arrivalTime);
    }

    public static By getDurationOfJourny(int index, int tBody, int indexOfFlight) {
        String durationOfJourney = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[" + index + "]/li[" + indexOfFlight + "]/div[contains(@class,'listItem')]/label/table/tbody[" + tBody + "]/tr//th[@class ='duration']";
        return By.xpath(durationOfJourney);
    }

    public static By priceOfFlight(int index, int tBody, int indexOfFlight) {
        String priceOfFlight = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[" + index + "]/li[" + indexOfFlight + "]/div[contains(@class,'listItem')]/label/table/tbody[" + tBody + "]/tr//th[@class ='price ']";
        return By.xpath(priceOfFlight);
    }

    public static By getFlightNumber(int index, int tBody, int indexOfFlight) {
        String flightNumber = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[" + index + "]/li[" + indexOfFlight + "]/div[contains(@class,'listItem')]/label/table/tbody[" + tBody + "]/tr//span[@class ='weak']";
        return By.xpath(flightNumber);
    }

    public static By getFlightName(int index, int tBody, int indexOfFlight) {
        String flightName = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[" + index + "]/li[" + indexOfFlight + "]/div[contains(@class,'listItem')]/label/table/tbody[" + tBody + "]/tr//span[@class ='truncate']";
        return By.xpath(flightName);
    }

    public static By getFlightSource(int index, int tBody, int indexOfFlight) {
        String flightSource = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[" + index + "]/li[" + indexOfFlight + "]/div[contains(@class,'listItem')]/label/table/tbody[" + tBody + "]/tr//abbr[1]";
        return By.xpath(flightSource);
    }

    public static By getFlightDestination(int index, int tBody, int indexOfFlight) {
        String flightDestination = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[" + index + "]/li[" + indexOfFlight + "]/div[contains(@class,'listItem')]/label/table/tbody[" + tBody + "]/tr//abbr[2]";
        return By.xpath(flightDestination);
    }

    public static By getLayOverTime(int index, int tBody, int indexOfFlight) {
        String layOverTime = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[" + index + "]/li[" + indexOfFlight + "]/div[contains(@class,'listItem')]/label/table/tbody[" + tBody + "]/tr//small[@class='layOver']";
        return By.xpath(layOverTime);
    }

    public static By getDepartAllflightDetails(int indexOFFlight) {
        String allDepatFlightDetails = "(//nav[@class = 'listViewNav']/ul[@class = 'listView flights'])[2]/li[" + indexOFFlight + "]/div[contains(@class,'listItem')]/label/table/tbody";
        return By.xpath(allDepatFlightDetails);
    }

    public static By getArrivalFlightDetails(int indexOFFlight) {
        String allArrivalFlightDetails = "(//nav[@class = 'listViewNav']/ul[@class = 'listView flights'])[3]/li[" + indexOFFlight + "]/div[contains(@class,'listItem')]/label/table/tbody";
        return By.xpath(allArrivalFlightDetails);
    }

    public static By getPriceButton(int index) {
        return By.xpath("(//a[@data-sort='price' and contains(text(),'Price')])[" + index + "]");
    }

    public static By getSourceOfNonStopFlight() {
        String nonStop = "(//nav[@class='listViewNav']/ul[@class='listView flights'])[3]/li[2]/div[contains(@class,'listItem')]/label/table/tbody[1]/tr//td[@class='duration']";
        return By.xpath(nonStop);
    }

    public static By getTotalHoursOfJourney(int index) {
        String totalHoursOfJourney = "(//div[contains(@class,'legInfo')])[" + index + "]//small[3]";
        return By.xpath(totalHoursOfJourney);
    }
}
