package edu.uchicago.umairmustafa.skyscanner;

public class Flight {
    private String source;
    private String destination;
    private String flightNumber;

    private String carrierCode;
    private String carrierName;
    private String carrierImageURL;

    private Double fare;
    private String departureTime;
    private String arrivalTime;
    private String deptDate;

    private String agentName;
    private String agentImageURL;
    private String bookingURL;

    public Flight() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCarrierImageURL() {
        return carrierImageURL;
    }

    public void setCarrierImageURL(String carrierImageURL) {
        this.carrierImageURL = carrierImageURL;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentImageURL() {
        return agentImageURL;
    }

    public void setAgentImageURL(String agentImageURL) {
        this.agentImageURL = agentImageURL;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getBookingURL() {
        return bookingURL;
    }

    public void setBookingURL(String bookingURL) {
        this.bookingURL = bookingURL;
    }

    public String getDeptDate() {
        return deptDate;
    }

    public void setDeptDate(String deptDate) {
        this.deptDate = deptDate;
    }

    @Override
    public String toString() {
        /*return "Flight{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", carrierCode='" + carrierCode + '\'' +
                ", carrierName='" + carrierName + '\'' +
                ", carrierImageURL='" + carrierImageURL + '\'' +
                ", fare='" + fare + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", agentName='" + agentName + '\'' +
                ", agentImageURL='" + agentImageURL + '\'' +
                ", bookingURL='" + bookingURL + '\'' +
                '}';*/
        return source + " -> " + destination + " | " + deptDate + " | " + carrierCode.toUpperCase() + flightNumber + " | $" + fare + " | " + agentName;
    }
}
