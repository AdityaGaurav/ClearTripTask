package com.cleartrip.retruntrip.pages;

import com.cleartrip.retruntrip.beans.FlightDetails;
import com.cleartrip.retruntrip.locators.FlightResultPageLocator;
import org.openqa.selenium.WebElement;
import utils.uiutils.FindElement;
import utils.uiutils.UIUtils;
import utils.uiutils.WaitForElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FlightResultPage {
    private static final int LEFT_SIDE_FLIGHT_INDEX = 2;
    private static final int RIGHT_SIDE_FLIGHT_INDEX = 3;
    private static long DEFAULT_TIME_OUT_IN_SECONDS = 60;
    private static int countBookButton = 1;

    public Map<String, FlightDetails> bookDepartFlight(int indexOfFlight) {
        WaitForElement.waitForVisibilityOfAllElementsLocatedBy(FlightResultPageLocator.leftSideFlightList(), DEFAULT_TIME_OUT_IN_SECONDS);
        return getDetailsOfDepartConnectingFlight(indexOfFlight);
    }

    public Map<String, FlightDetails> bookArrivalFlight(int indexOfFlight) {
        WaitForElement.waitForVisibilityOfAllElementsLocatedBy(FlightResultPageLocator.rightSideFlightList(), DEFAULT_TIME_OUT_IN_SECONDS);
        return getDetailsOfArrivalConnectingFlight(indexOfFlight);
    }


    public Map<String, FlightDetails> getSelectedFlightDetails(int indexOfFlight){
        return getDetailsOfDepartConnectingFlight(indexOfFlight);
    }
    public void clickOnPriceButton() {
        WaitForElement.waitForVisibilityOfAllElementsLocatedBy(FlightResultPageLocator.leftSideFlightList(), DEFAULT_TIME_OUT_IN_SECONDS);
        WebElement priceButton = FindElement.findElementOnPage(FlightResultPageLocator.getPriceButton(countBookButton), DEFAULT_TIME_OUT_IN_SECONDS);
        priceButton.click();
        WaitForElement.waitForVisibilityOfAllElementsLocatedBy(FlightResultPageLocator.leftSideFlightList(), DEFAULT_TIME_OUT_IN_SECONDS);
        countBookButton++;
        if (countBookButton > 2) {
            countBookButton = 1;
        }
    }

//    public int getDepatFlightDetails(int indexOfFlight) {
//        List<WebElement> allFlightDetails = FindElement.findElementsOnPage(FlightResultPageLocator.getDepartAllflightDetails(indexOfFlight), 30);
//        return allFlightDetails.size();
//    }

    private FlightDetails getAllFlightDetails(int indexOfSide, int indexOftbody, int indexOfFlight, boolean flag, String nonStopFlight) {
        FlightDetails flightDetails = new FlightDetails();
        String departureTime;
        String arrivalTime;
        String travelDuration;
        String flightName;
        String flightNumber;
        String flightSource;
        String flightDestination;
        String price;
//        String totalHoursOfJourney;
        departureTime = FindElement.findElement(FlightResultPageLocator.getDepartTime(indexOfSide, indexOftbody, indexOfFlight)).getText().trim();
        flightDetails.setDepartTime(departureTime);
        arrivalTime = FindElement.findElementOnPage(FlightResultPageLocator.getArrivalTime(indexOfSide, indexOftbody, indexOfFlight), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
        flightDetails.setArrivalTime(arrivalTime);
        travelDuration = FindElement.findElementOnPage(FlightResultPageLocator.getDurationOfJourny(indexOfSide, indexOftbody, indexOfFlight), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
        flightDetails.setJourneyDuration(travelDuration);
        flightName = FindElement.findElementOnPage(FlightResultPageLocator.getFlightName(indexOfSide, indexOftbody, indexOfFlight), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
        flightDetails.setFlightName(concatenateString(flightName));
        flightNumber = FindElement.findElementOnPage(FlightResultPageLocator.getFlightNumber(indexOfSide, indexOftbody, indexOfFlight), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
        flightDetails.setFlightNumber(flightNumber);
        if (!nonStopFlight.equalsIgnoreCase("non-stop")) {
            flightSource = FindElement.findElementOnPage(FlightResultPageLocator.getFlightSource(indexOfSide, indexOftbody, indexOfFlight), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
            flightDetails.setFlightSource(flightSource);
            flightDestination = FindElement.findElementOnPage(FlightResultPageLocator.getFlightDestination(indexOfSide, indexOftbody, indexOfFlight), DEFAULT_TIME_OUT_IN_SECONDS).getText().trim();
            flightDetails.setFlightDestination(flightDestination);
        } else {
            flightDetails.setFlightSource(getContentFromURL()[0]);
            flightDetails.setFlightDestination(getContentFromURL()[1]);
        }
        if (flag) {
            clickOnRadioButton(indexOfSide, indexOftbody, indexOfFlight);
        }
        return flightDetails;
    }

    private Map<String, FlightDetails> getDetailsOfDepartConnectingFlight(int indexOFFlight) {
        List<WebElement> element = FindElement.listOFElements(FlightResultPageLocator.getDepartAllflightDetails(indexOFFlight));
        int detailsOfIndex = element.size();
        Map<String, FlightDetails> flightDetailsMap = new LinkedHashMap<>();
        boolean priceFlag = true;
        int count =1;
        if (detailsOfIndex > 1) {
            for (int i = 1; i < detailsOfIndex + 1; i++) {
                flightDetailsMap.put("Depart " + count, getAllFlightDetails(LEFT_SIDE_FLIGHT_INDEX, i, indexOFFlight, priceFlag, ""));
                priceFlag = false;
                count++;
                i = i + 1;
            }
        } else {
            flightDetailsMap.put("Depart "+count, getAllFlightDetails(LEFT_SIDE_FLIGHT_INDEX, 1, indexOFFlight, priceFlag, "non-stop"));
        }
        return flightDetailsMap;
    }

    private Map<String, FlightDetails> getDetailsOfArrivalConnectingFlight(int indexOFFlight) {
        List<WebElement> element = FindElement.listOFElements(FlightResultPageLocator.getArrivalFlightDetails(indexOFFlight));
        int detailsOfIndex = element.size();
        Map<String, FlightDetails> flightDetailsMap = new LinkedHashMap<>();
        boolean priceFlag = true;
        int count = 1;
        if (detailsOfIndex > 1) {
            for (int i = 1; i < detailsOfIndex + 1; i++) {
                flightDetailsMap.put("Arrival " + count, getAllFlightDetails(RIGHT_SIDE_FLIGHT_INDEX, i, indexOFFlight, priceFlag, ""));
                priceFlag = false;
                count++;
                i = i + 1;
            }
        } else {
            flightDetailsMap.put("Arrival " + count, getAllFlightDetails(RIGHT_SIDE_FLIGHT_INDEX, 1, indexOFFlight, priceFlag, "non-stop"));
        }
        return flightDetailsMap;
    }

    public void clickOnRadioButton(int indexOfSide, int indexOftbody, int indexOfFlight) {
        FindElement.findElement(FlightResultPageLocator.getRadioButton(indexOfSide, indexOftbody, indexOfFlight)).click();
    }

    public FlightItineraryPage clickOnBookButton() {
        FindElement.findElement(FlightResultPageLocator.BOOK_BUTTON).click();
        return new FlightItineraryPage();
    }

    private String[] getContentFromURL() {
        String URL = UIUtils.getCurrentURL();
        String[] URLContent = URL.split("\\?")[1].split("&");
        String[] cityDetails = new String[2];
        cityDetails[0] = URLContent[0].split("=")[1].trim();
        cityDetails[1] = URLContent[1].split("=")[1].trim();
        return cityDetails;
    }

    private String concatenateString(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] splitString = inputString.split(" ");
        for (int i = 0; i < splitString.length - 1; i++) {
            stringBuilder.append(splitString[i]+" ");
        }
        return stringBuilder.toString().trim();
    }
}
