
package edu.uchicago.umairmustafa.skyscanner.skyscannerresponse;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Segment {

    @SerializedName("Directionality")
    @Expose
    private String directionality;
    @SerializedName("OriginStation")
    @Expose
    private Integer originStation;
    @SerializedName("DepartureDateTime")
    @Expose
    private String departureDateTime;
    @SerializedName("ArrivalDateTime")
    @Expose
    private String arrivalDateTime;
    @SerializedName("JourneyMode")
    @Expose
    private String journeyMode;
    @SerializedName("DestinationStation")
    @Expose
    private Integer destinationStation;
    @SerializedName("OperatingCarrier")
    @Expose
    private Integer operatingCarrier;
    @SerializedName("FlightNumber")
    @Expose
    private String flightNumber;
    @SerializedName("Duration")
    @Expose
    private Integer duration;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Carrier")
    @Expose
    private Integer carrier;

    /**
     * 
     * @return
     *     The directionality
     */
    public String getDirectionality() {
        return directionality;
    }

    /**
     * 
     * @param directionality
     *     The Directionality
     */
    public void setDirectionality(String directionality) {
        this.directionality = directionality;
    }

    /**
     * 
     * @return
     *     The originStation
     */
    public Integer getOriginStation() {
        return originStation;
    }

    /**
     * 
     * @param originStation
     *     The OriginStation
     */
    public void setOriginStation(Integer originStation) {
        this.originStation = originStation;
    }

    /**
     * 
     * @return
     *     The departureDateTime
     */
    public String getDepartureDateTime() {
        return departureDateTime;
    }

    /**
     * 
     * @param departureDateTime
     *     The DepartureDateTime
     */
    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    /**
     * 
     * @return
     *     The arrivalDateTime
     */
    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    /**
     * 
     * @param arrivalDateTime
     *     The ArrivalDateTime
     */
    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    /**
     * 
     * @return
     *     The journeyMode
     */
    public String getJourneyMode() {
        return journeyMode;
    }

    /**
     * 
     * @param journeyMode
     *     The JourneyMode
     */
    public void setJourneyMode(String journeyMode) {
        this.journeyMode = journeyMode;
    }

    /**
     * 
     * @return
     *     The destinationStation
     */
    public Integer getDestinationStation() {
        return destinationStation;
    }

    /**
     * 
     * @param destinationStation
     *     The DestinationStation
     */
    public void setDestinationStation(Integer destinationStation) {
        this.destinationStation = destinationStation;
    }

    /**
     * 
     * @return
     *     The operatingCarrier
     */
    public Integer getOperatingCarrier() {
        return operatingCarrier;
    }

    /**
     * 
     * @param operatingCarrier
     *     The OperatingCarrier
     */
    public void setOperatingCarrier(Integer operatingCarrier) {
        this.operatingCarrier = operatingCarrier;
    }

    /**
     * 
     * @return
     *     The flightNumber
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * 
     * @param flightNumber
     *     The FlightNumber
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * 
     * @return
     *     The duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The Duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The carrier
     */
    public Integer getCarrier() {
        return carrier;
    }

    /**
     * 
     * @param carrier
     *     The Carrier
     */
    public void setCarrier(Integer carrier) {
        this.carrier = carrier;
    }

}
