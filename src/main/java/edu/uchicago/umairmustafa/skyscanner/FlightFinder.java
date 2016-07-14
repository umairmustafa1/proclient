package edu.uchicago.umairmustafa.skyscanner;

import com.google.gson.Gson;
import edu.uchicago.umairmustafa.skyscanner.skyscannerresponse.JsonResponse;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class FlightFinder {

    private final String USER_AGENT = "Mozilla/5.0";
    private final String POST_URL = "http://partners.api.skyscanner.net/apiservices/pricing/v1.0";
    private final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private final String ACCEPT = "application/json";
    private final String API_KEY = "mu994245248718593845972967217569";
    private final String CURRENCY = "USD";
    private final String COUNTRY = "US";
    private final String LOCALE = "en-us";
    private final String LOCATION_SCHEMA = "Iata";
    private final String SORT_TYPE = "price";
    private final String SORT_ORDER = "asc";
    private final String PAGE_INDEX = "0";
    private final String PAGE_SIZE = "1";
    private final String INCLUDE_QUERY = "false";
    private final String INCLUDE_CURRENCY_LOOKUP = "false";
    private final String INCLUDE_BOOKING_DETAILS_LINK = "false";

    private String origin;
    private String destination;
    private String startDate;
    private String endDate;
    private String numofAdults;
    private String getUrl;
    private String strResult;
    private ArrayList<Flight> flightList;

    public FlightFinder(String origin, String destination, String startDate, String endDate, String numOfAdults) {
        this.origin = origin;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numofAdults = numOfAdults;
        this.getUrl = "";
        this.strResult = "";
        this.flightList = new ArrayList<>();
        findFlights();
    }

    private void findFlights(){

        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate start = formatter.parse(this.startDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate end = formatter.parse(this.endDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
                Flight flight = findFlight(origin, destination, date.toString() , numofAdults);
                if(flight != null){
                    flightList.add(flight);
                }
            }
        }catch(Exception pe){
            pe.printStackTrace();
        }
    }

    private Flight findFlight(String origin, String destination, String outboundDate, String numofAdults){

        int responseCode = sendPost(POST_URL, origin, destination, outboundDate, numofAdults);
        System.out.println(responseCode);//TODO
        Flight flight = null;
        if(responseCode == 201){
            getUrl = getUrl + "?apiKey=" + API_KEY;
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            responseCode = sendGet(getUrl);
            System.out.println(responseCode);//TODO
            if(responseCode == 200){

                /*JSONObject obj = new JSONObject(strResult);
                System.out.println(obj.toString());//TODO*/

                JsonResponse jsonResponse = new Gson().fromJson(strResult, JsonResponse.class);
                flight = new Flight();

                flight.setSource(origin);
                flight.setDestination(destination);
                flight.setFlightNumber(jsonResponse.getLegs().get(0).getFlightNumbers().get(0).getFlightNumber().toString());

                flight.setCarrierCode(jsonResponse.getCarriers().get(0).getDisplayCode());
                flight.setCarrierName(jsonResponse.getCarriers().get(0).getName());
                flight.setCarrierImageURL(jsonResponse.getCarriers().get(0).getImageUrl());

                flight.setFare(jsonResponse.getItineraries().get(0).getPricingOptions().get(0).getPrice());
                flight.setDepartureTime(jsonResponse.getLegs().get(0).getDeparture());
                flight.setArrivalTime(jsonResponse.getLegs().get(0).getArrival());
                flight.setDeptDate(outboundDate);

                flight.setAgentName(jsonResponse.getAgents().get(0).getName());
                flight.setAgentImageURL(jsonResponse.getAgents().get(0).getImageUrl());
                flight.setBookingURL(jsonResponse.getItineraries().get(0).getPricingOptions().get(0).getDeeplinkUrl());

                System.out.println(flight);//TODO
            };
        };
        return flight;
    }

    private int sendGet(String url){

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();

        urlParameters.add(new BasicNameValuePair("sorttype", SORT_TYPE));
        urlParameters.add(new BasicNameValuePair("sortorder", SORT_ORDER));
        urlParameters.add(new BasicNameValuePair("pageindex", PAGE_INDEX));
        urlParameters.add(new BasicNameValuePair("pagesize", PAGE_SIZE));
        urlParameters.add(new BasicNameValuePair("includeQuery", INCLUDE_QUERY));
        urlParameters.add(new BasicNameValuePair("includeCurrencyLookup", INCLUDE_CURRENCY_LOOKUP));
        urlParameters.add(new BasicNameValuePair("includeBookingDetailsLink", INCLUDE_BOOKING_DETAILS_LINK));

        String params = URLEncodedUtils.format(urlParameters, "utf-8");
        url = url + "&" + params;

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        request.addHeader("User-Agent", USER_AGENT);

        int responseCode = 0;

        try {
            HttpResponse response = client.execute(request);
            responseCode = response.getStatusLine().getStatusCode();

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            strResult = result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseCode;
    }

    private int sendPost(String url, String origin, String destination, String outboundDate, String numofAdults){
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();

        urlParameters.add(new BasicNameValuePair("Content-Type", CONTENT_TYPE));
        urlParameters.add(new BasicNameValuePair("Accept", ACCEPT));
        urlParameters.add(new BasicNameValuePair("apiKey", API_KEY));
        urlParameters.add(new BasicNameValuePair("currency", CURRENCY));
        urlParameters.add(new BasicNameValuePair("country", COUNTRY));
        urlParameters.add(new BasicNameValuePair("locale", LOCALE));
        urlParameters.add(new BasicNameValuePair("locationschema", LOCATION_SCHEMA));

        urlParameters.add(new BasicNameValuePair("originplace", origin));
        urlParameters.add(new BasicNameValuePair("destinationplace", destination));
        urlParameters.add(new BasicNameValuePair("OutboundDate", outboundDate));
        urlParameters.add(new BasicNameValuePair("adults", numofAdults));

        int responseCode = 0;

        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
            HttpResponse response = client.execute(post);
            responseCode = response.getStatusLine().getStatusCode();
            Header[] headers = response.getAllHeaders();
            getUrl = Arrays.stream(headers).filter(header -> header.getName().equals("Location")).map(header -> header.getValue()).collect(Collectors.joining(""));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getNumofAdults() {
        return numofAdults;
    }

    public void setNumofAdults(String numofAdults) {
        this.numofAdults = numofAdults;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(ArrayList<Flight> flightList) {
        this.flightList = flightList;
    }
}


