package com.cleartrip.retruntrip.locators;

import org.openqa.selenium.By;

public class FlightItineraryPageLocator {

    public static By waitForElementToLoadPage() {
        String element = "//div[contains(@class,'col col18  hasBaggageInfo')]";
        return By.xpath(element);
    }

    public static By getFlightCount(String flightType) {
        String flightCount = "//div[contains(@class,'" + flightType + "')]";
        String count = String.format("//div[contains(@class,'%s')",flightType);
        return By.xpath(flightCount);
    }

    public static By getFlightName(String flightType, int indexOfFlight) {
        String getFlightName = "(//div[contains(@class,'" + flightType + "')]//span[@class ='name'])[" + indexOfFlight + "]";
        return By.xpath(getFlightName);
    }

    public static By getFlightNumber(String flightType, int indexOfFlight) {
        String flightNumber = "(//div[contains(@class,'" + flightType + "')]//small[@class='flightNumber'])[" + indexOfFlight + "]";
        return By.xpath(flightNumber);
    }

    public static By getFlightLocation(String flightType, int indexOfFlightLocation) {
        String flightLocation = "(//div[contains(@class,'" + flightType + "')]//span[@class='placeTime']/span)[" + indexOfFlightLocation + "]";
        return By.xpath(flightLocation);
    }

    public static By getFlightTiming(String flightType, int indexOfFlightTiming) {
        String flightTiming = "(//div[contains(@class,'" + flightType + "')]//span[@class='placeTime']/strong)[" + indexOfFlightTiming + "]";
        return By.xpath(flightTiming);
    }

    public static By getFlightDuration(String flightType, int indexOfFlight) {
        String flightDuration = "(//div[contains(@class,'" + flightType + "')]//abbr[@class='duration weak'])[" + indexOfFlight + "]";
        return By.xpath(flightDuration);
    }
}
