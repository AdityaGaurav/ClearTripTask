package com.cleartrip.retruntrip.beans;

public class FlightDetails {
    private String departTime;
    private String arrivalTime;
    private String journeyDuration;
    private String flightName;
    private String flightNumber;
    private String flightDestination;
    private String flightSource;

    public String getFlightDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getFlightArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFlightDuration() {
        return journeyDuration;
    }

    public void setJourneyDuration(String journeyDuration) {
        this.journeyDuration = journeyDuration;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightDepartSource() {
        return flightSource;
    }

    public void setFlightSource(String flightSource) {
        this.flightSource = flightSource;
    }

    public String getFlightArrivalDestination() {
        return flightDestination;
    }

    public void setFlightDestination(String flightDestination) {
        this.flightDestination = flightDestination;
    }

    @Override
    public String toString() {
        return "Depart Time: " + departTime
                + "Arrival Time: " + arrivalTime + "\nDuration of Journey: " + journeyDuration +
                "\nFlight Name: " + flightName + "\nFlight Number: " + flightNumber +
                "\nFlight Destination: " + flightDestination + "\nFlight Source: " + flightSource;
    }
}
