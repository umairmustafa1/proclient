
package edu.uchicago.umairmustafa.skyscanner.skyscannerresponse;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class JsonResponse {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Carriers")
    @Expose
    private List<Carrier> carriers = new ArrayList<Carrier>();
    @SerializedName("Legs")
    @Expose
    private List<Leg> legs = new ArrayList<Leg>();
    @SerializedName("Itineraries")
    @Expose
    private List<Itinerary> itineraries = new ArrayList<Itinerary>();
    @SerializedName("SessionKey")
    @Expose
    private String sessionKey;
    @SerializedName("Agents")
    @Expose
    private List<Agent> agents = new ArrayList<Agent>();
    @SerializedName("Segments")
    @Expose
    private List<Segment> segments = new ArrayList<Segment>();
    @SerializedName("Places")
    @Expose
    private List<Place> places = new ArrayList<Place>();

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The Status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The carriers
     */
    public List<Carrier> getCarriers() {
        return carriers;
    }

    /**
     * 
     * @param carriers
     *     The Carriers
     */
    public void setCarriers(List<Carrier> carriers) {
        this.carriers = carriers;
    }

    /**
     * 
     * @return
     *     The legs
     */
    public List<Leg> getLegs() {
        return legs;
    }

    /**
     * 
     * @param legs
     *     The Legs
     */
    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    /**
     * 
     * @return
     *     The itineraries
     */
    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    /**
     * 
     * @param itineraries
     *     The Itineraries
     */
    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    /**
     * 
     * @return
     *     The sessionKey
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * 
     * @param sessionKey
     *     The SessionKey
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * 
     * @return
     *     The agents
     */
    public List<Agent> getAgents() {
        return agents;
    }

    /**
     * 
     * @param agents
     *     The Agents
     */
    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    /**
     * 
     * @return
     *     The segments
     */
    public List<Segment> getSegments() {
        return segments;
    }

    /**
     * 
     * @param segments
     *     The Segments
     */
    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    /**
     * 
     * @return
     *     The places
     */
    public List<Place> getPlaces() {
        return places;
    }

    /**
     * 
     * @param places
     *     The Places
     */
    public void setPlaces(List<Place> places) {
        this.places = places;
    }

}
