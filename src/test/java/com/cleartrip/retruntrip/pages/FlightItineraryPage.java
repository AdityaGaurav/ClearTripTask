package com.cleartrip.retruntrip.pages;

import com.cleartrip.retruntrip.beans.FlightItinerary;
import com.cleartrip.retruntrip.locators.FlightItineraryPageLocator;
import org.openqa.selenium.WebElement;
import utils.uiutils.FindElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FlightItineraryPage {
    private static long DEFAULT_TIME_OUT_IN_SECONDS = 60;

    public void getDetailsOfFlights() {
          FindElement.waitForVisibilityOfAllElementsLocatedBy(FlightItineraryPageLocator.waitForElementToLoadPage(),DEFAULT_TIME_OUT_IN_SECONDS);
    }

    public Map<String, FlightItinerary> getDetailsOfDepartFlight() {
        Map<String, FlightItinerary> flightItineraryMap = new LinkedHashMap<>();
        String flightType = "onwBlock";
        List<WebElement> listOfElements = FindElement.listOFElements(FlightItineraryPageLocator.getFlightCount(flightType));
        for (int i = 1; i <= listOfElements.size(); i++) {
            flightItineraryMap.put("Depart " + i, getDetailsOfFlight(flightType, i));
        }
        return flightItineraryMap;
    }

    public Map<String, FlightItinerary> getDetailsOfArrivalFlight() {
        Map<String, FlightItinerary> flightItineraryMap = new LinkedHashMap<>();
        String flightType = "retBlock";
        List<WebElement> listOfElements = FindElement.listOFElements(FlightItineraryPageLocator.getFlightCount(flightType));
        for (int i = 1; i <= listOfElements.size(); i++) {
            flightItineraryMap.put("Arrival " + i, getDetailsOfFlight(flightType, i));
        }
        return flightItineraryMap;
    }

    private FlightItinerary getDetailsOfFlight(String flightType, int indexOfFlight) {
        FlightItinerary flightItinerary = new FlightItinerary();
        String flightName;
        String flightNumber;
        String flightSource;
        String flightDestination;
        String flightDepartTiming;
        String flightArrivalTiming;
        String flightDuration;

        flightName = FindElement.findElementOnPage(FlightItineraryPageLocator.getFlightName(flightType, indexOfFlight), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
        flightItinerary.setFlightName(flightName);

        flightNumber = FindElement.findElementOnPage(FlightItineraryPageLocator.getFlightNumber(flightType, indexOfFlight), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
        flightItinerary.setFlightNumber(flightNumber);

        flightSource = FindElement.findElementOnPage(FlightItineraryPageLocator.getFlightLocation(flightType, formIndexOfElement(indexOfFlight)[0]), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
        flightItinerary.setFlightDepartSource(flightSource);

        flightDestination = FindElement.findElementOnPage(FlightItineraryPageLocator.getFlightLocation(flightType, formIndexOfElement(indexOfFlight)[1]), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
        flightItinerary.setFlightArrivalDest(flightDestination);

        flightDepartTiming = FindElement.findElementOnPage(FlightItineraryPageLocator.getFlightTiming(flightType, formIndexOfElement(indexOfFlight)[0]), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
        flightItinerary.setFlightDepartTime(flightDepartTiming);

        flightArrivalTiming = FindElement.findElementOnPage(FlightItineraryPageLocator.getFlightTiming(flightType, formIndexOfElement(indexOfFlight)[1]),DEFAULT_TIME_OUT_IN_SECONDS ).getText().trim();
        flightItinerary.setFlightArrivalTime(flightArrivalTiming);

        flightDuration = FindElement.findElementOnPage(FlightItineraryPageLocator.getFlightDuration(flightType, indexOfFlight), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
        flightItinerary.setFlightDuration(flightDuration);

        return flightItinerary;
    }

    private int[] formIndexOfElement(int indexOfFlight) {
        int[] indexOfElement = new int[2];
        int count = 0;
        for (int i = indexOfFlight; i < indexOfFlight * 2; i = i * 2 - 1) {
            if (i == 1) {
                indexOfElement[0] = 1;
                indexOfElement[1] = 2;
                return indexOfElement;
            } else {
                indexOfElement[count] = i + 1;
                count++;
            }
        }
        return indexOfElement;
    }
}
