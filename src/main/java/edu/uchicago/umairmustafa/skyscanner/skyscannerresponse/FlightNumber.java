
package edu.uchicago.umairmustafa.skyscanner.skyscannerresponse;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class FlightNumber {

    @SerializedName("CarrierId")
    @Expose
    private Integer carrierId;
    @SerializedName("FlightNumber")
    @Expose
    private String flightNumber;

    /**
     * 
     * @return
     *     The carrierId
     */
    public Integer getCarrierId() {
        return carrierId;
    }

    /**
     * 
     * @param carrierId
     *     The CarrierId
     */
    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
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

}
