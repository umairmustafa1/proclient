
package edu.uchicago.umairmustafa.skyscanner.skyscannerresponse;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PricingOption {

    @SerializedName("DeeplinkUrl")
    @Expose
    private String deeplinkUrl;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("Agents")
    @Expose
    private List<Integer> agents = new ArrayList<Integer>();
    @SerializedName("QuoteAgeInMinutes")
    @Expose
    private Integer quoteAgeInMinutes;

    /**
     * 
     * @return
     *     The deeplinkUrl
     */
    public String getDeeplinkUrl() {
        return deeplinkUrl;
    }

    /**
     * 
     * @param deeplinkUrl
     *     The DeeplinkUrl
     */
    public void setDeeplinkUrl(String deeplinkUrl) {
        this.deeplinkUrl = deeplinkUrl;
    }

    /**
     * 
     * @return
     *     The price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The Price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The agents
     */
    public List<Integer> getAgents() {
        return agents;
    }

    /**
     * 
     * @param agents
     *     The Agents
     */
    public void setAgents(List<Integer> agents) {
        this.agents = agents;
    }

    /**
     * 
     * @return
     *     The quoteAgeInMinutes
     */
    public Integer getQuoteAgeInMinutes() {
        return quoteAgeInMinutes;
    }

    /**
     * 
     * @param quoteAgeInMinutes
     *     The QuoteAgeInMinutes
     */
    public void setQuoteAgeInMinutes(Integer quoteAgeInMinutes) {
        this.quoteAgeInMinutes = quoteAgeInMinutes;
    }

}
