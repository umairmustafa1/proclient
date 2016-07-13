
package edu.uchicago.umairmustafa.skyscanner.skyscannerresponse;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Agent {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("OptimisedForMobile")
    @Expose
    private Boolean optimisedForMobile;
    @SerializedName("BookingNumber")
    @Expose
    private String bookingNumber;
    @SerializedName("Name")
    @Expose
    private String name;

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
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The Type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     * @param imageUrl
     *     The ImageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
     *     The optimisedForMobile
     */
    public Boolean getOptimisedForMobile() {
        return optimisedForMobile;
    }

    /**
     * 
     * @param optimisedForMobile
     *     The OptimisedForMobile
     */
    public void setOptimisedForMobile(Boolean optimisedForMobile) {
        this.optimisedForMobile = optimisedForMobile;
    }

    /**
     * 
     * @return
     *     The bookingNumber
     */
    public String getBookingNumber() {
        return bookingNumber;
    }

    /**
     * 
     * @param bookingNumber
     *     The BookingNumber
     */
    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The Name
     */
    public void setName(String name) {
        this.name = name;
    }

}
