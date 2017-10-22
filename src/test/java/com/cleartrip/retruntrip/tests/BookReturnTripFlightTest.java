package com.cleartrip.retruntrip.tests;

import com.cleartrip.retruntrip.beans.FlightDetails;
import com.cleartrip.retruntrip.beans.FlightItinerary;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.cleartrip.retruntrip.pages.FlightItineraryPage;
import com.cleartrip.retruntrip.pages.FlightResultPage;
import com.cleartrip.retruntrip.pages.FlightsHomePage;
import utils.basepage.BasePage;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookReturnTripFlightTest extends BasePage {


    @Parameters({"tripType","fromCityNameWithCountryCode","toCityNameWithCountryCode","departureDate","returnDate","adultValue","childrenValue","infantsValue","selectFlightAsPerHighestPrice"})
    @Test
    void test_verifyDetailsOfBookedFlight(String tripType, String fromCityNameWithCountryCode, String toCityNameWithCountryCode, String departureDate, String returnDate, String adultValue, String childrenValue, String infantsValue, int selectFlightAsPerHighestPrice) throws ParseException {
        FlightsHomePage flightsHomePage = new FlightsHomePage();
//        FlightResultPage flightResultPage = flightsHomePage.bookFlight("RoundTrip", "Hyderabad, IN",
//                "Lucknow, IN", "17\\11\\2017", "20\\11\\2017",
//                "2", "0", "0");
        FlightResultPage flightResultPage = flightsHomePage.bookFlight(tripType, fromCityNameWithCountryCode,
                toCityNameWithCountryCode, departureDate, returnDate, adultValue, childrenValue, infantsValue);
        Map<String, Map<String, FlightDetails>> flightResultPageDetails = new LinkedHashMap<>();
        int indexOfFlight = 2;
        flightResultPage.clickOnPriceButton();
        flightResultPageDetails.put("Depart", flightResultPage.bookDepartFlight(selectFlightAsPerHighestPrice));
        flightResultPage.clickOnPriceButton();
        flightResultPageDetails.put("Arrival", flightResultPage.bookArrivalFlight(selectFlightAsPerHighestPrice));
        FlightItineraryPage flightItineraryPage = flightResultPage.clickOnBookButton();
        flightItineraryPage.getDetailsOfFlights();
        Map<String, Map<String, FlightItinerary>> flightItineraryPageDetails = new LinkedHashMap<>();
        flightItineraryPageDetails.put("Depart", flightItineraryPage.getDetailsOfDepartFlight());
        flightItineraryPageDetails.put("Arrival", flightItineraryPage.getDetailsOfArrivalFlight());
        verifyFlightDetails(flightResultPageDetails, flightItineraryPageDetails);
    }

    private void verifyFlightDetails(Map<String, Map<String, FlightDetails>> mapResult, Map<String, Map<String, FlightItinerary>> mapItinerary) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mapResult.size(), mapItinerary.size());
        softAssert.assertEquals(mapResult.keySet(), mapItinerary.keySet());
        softAssert.assertAll();
        for (String str : mapResult.keySet()) {
            for (String str2 : mapResult.get(str).keySet()) {
                FlightDetails flightDetails = mapResult.get(str).get(str2);
                FlightItinerary flightItinerary = mapItinerary.get(str).get(str2);
                compareDetailsOfFlight(flightDetails, flightItinerary);
            }
        }
    }

    private void compareDetailsOfFlight(FlightDetails flightDetails, FlightItinerary flightItinerary) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(flightDetails.getFlightName(), flightItinerary.getFlightName(), "Flight name does not match[" + flightDetails.getFlightName() + "] [" + flightItinerary.getFlightName() + "]");
        softAssert.assertEquals(flightDetails.getFlightNumber(), flightItinerary.getFlightNumber(), "Flight Number");
        softAssert.assertEquals(flightDetails.getFlightDepartTime(), flightItinerary.getFlightDepartTime(), "Flight Departure Time");
        softAssert.assertEquals(flightDetails.getFlightArrivalTime(), flightItinerary.getFlightArrivalTime(), "Flight Arrival Time");
        softAssert.assertEquals(flightDetails.getFlightDepartSource(), flightItinerary.getFlightDepartSource(), "Flight Departure Source");
        softAssert.assertEquals(flightDetails.getFlightArrivalDestination(), flightItinerary.getFlightArrivalDest(), "Flight Arrival Destination");
        softAssert.assertEquals(flightDetails.getFlightDuration(), flightItinerary.getFlightDuration(), "Flight Duration");
        softAssert.assertAll();
    }
}
