
package edu.uchicago.umairmustafa.skyscanner.skyscannerresponse;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Leg {

    @SerializedName("SegmentIds")
    @Expose
    private List<Integer> segmentIds = new ArrayList<Integer>();
    @SerializedName("Duration")
    @Expose
    private Integer duration;
    @SerializedName("Arrival")
    @Expose
    private String arrival;
    @SerializedName("Carriers")
    @Expose
    private List<Integer> carriers = new ArrayList<Integer>();
    @SerializedName("Directionality")
    @Expose
    private String directionality;
    @SerializedName("OriginStation")
    @Expose
    private Integer originStation;
    @SerializedName("Departure")
    @Expose
    private String departure;
    @SerializedName("FlightNumbers")
    @Expose
    private List<FlightNumber> flightNumbers = new ArrayList<FlightNumber>();
    @SerializedName("JourneyMode")
    @Expose
    private String journeyMode;
    @SerializedName("DestinationStation")
    @Expose
    private Integer destinationStation;
    @SerializedName("Stops")
    @Expose
    private List<Object> stops = new ArrayList<Object>();
    @SerializedName("OperatingCarriers")
    @Expose
    private List<Integer> operatingCarriers = new ArrayList<Integer>();
    @SerializedName("Id")
    @Expose
    private String id;

    /**
     * 
     * @return
     *     The segmentIds
     */
    public List<Integer> getSegmentIds() {
        return segmentIds;
    }

    /**
     * 
     * @param segmentIds
     *     The SegmentIds
     */
    public void setSegmentIds(List<Integer> segmentIds) {
        this.segmentIds = segmentIds;
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
     *     The arrival
     */
    public String getArrival() {
        return arrival;
    }

    /**
     * 
     * @param arrival
     *     The Arrival
     */
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    /**
     * 
     * @return
     *     The carriers
     */
    public List<Integer> getCarriers() {
        return carriers;
    }

    /**
     * 
     * @param carriers
     *     The Carriers
     */
    public void setCarriers(List<Integer> carriers) {
        this.carriers = carriers;
    }

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
     *     The departure
     */
    public String getDeparture() {
        return departure;
    }

    /**
     * 
     * @param departure
     *     The Departure
     */
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    /**
     * 
     * @return
     *     The flightNumbers
     */
    public List<FlightNumber> getFlightNumbers() {
        return flightNumbers;
    }

    /**
     * 
     * @param flightNumbers
     *     The FlightNumbers
     */
    public void setFlightNumbers(List<FlightNumber> flightNumbers) {
        this.flightNumbers = flightNumbers;
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
     *     The stops
     */
    public List<Object> getStops() {
        return stops;
    }

    /**
     * 
     * @param stops
     *     The Stops
     */
    public void setStops(List<Object> stops) {
        this.stops = stops;
    }

    /**
     * 
     * @return
     *     The operatingCarriers
     */
    public List<Integer> getOperatingCarriers() {
        return operatingCarriers;
    }

    /**
     * 
     * @param operatingCarriers
     *     The OperatingCarriers
     */
    public void setOperatingCarriers(List<Integer> operatingCarriers) {
        this.operatingCarriers = operatingCarriers;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The Id
     */
    public void setId(String id) {
        this.id = id;
    }

}
