
package edu.uchicago.umairmustafa.skyscanner.skyscannerresponse;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Itinerary {

    @SerializedName("OutboundLegId")
    @Expose
    private String outboundLegId;
    @SerializedName("PricingOptions")
    @Expose
    private List<PricingOption> pricingOptions = new ArrayList<PricingOption>();

    /**
     * 
     * @return
     *     The outboundLegId
     */
    public String getOutboundLegId() {
        return outboundLegId;
    }

    /**
     * 
     * @param outboundLegId
     *     The OutboundLegId
     */
    public void setOutboundLegId(String outboundLegId) {
        this.outboundLegId = outboundLegId;
    }

    /**
     * 
     * @return
     *     The pricingOptions
     */
    public List<PricingOption> getPricingOptions() {
        return pricingOptions;
    }

    /**
     * 
     * @param pricingOptions
     *     The PricingOptions
     */
    public void setPricingOptions(List<PricingOption> pricingOptions) {
        this.pricingOptions = pricingOptions;
    }

}
