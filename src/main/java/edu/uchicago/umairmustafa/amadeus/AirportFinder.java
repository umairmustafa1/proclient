package edu.uchicago.umairmustafa.amadeus;

import com.google.gson.Gson;

public class AirportFinder {
    public static final String apiKey = "xTjMLxc6ZxwQE2greu788BjGIUunf0EP";
    public static final String apiURL = "http://api.sandbox.amadeus.com/v1.2/airports/autocomplete?";

    public static AirportResult[] findAirports(String key){
        String apiLink = apiURL + "apikey=" + apiKey + "&term=" + key;
        String jsonStr = null;
        try{
            jsonStr = WebJsonParser.sendGet(apiLink);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        AirportResult[] results = new Gson().fromJson(jsonStr, AirportResult[].class);
        return results;
    }

    /*public static void main(String[] args) {
        System.out.println(findAirports("BAN"));
    }*/
}
