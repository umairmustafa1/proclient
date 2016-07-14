package edu.uchicago.umairmustafa.airports;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileAirportFinder {

    public static ArrayList<Airport> findAirports(String key){
        String jsonStr = null;
        try {
            jsonStr = new String(Files.readAllBytes(Paths.get("./src/main/resources/json/airports.json")), Charset.defaultCharset());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Airport[] results = new Gson().fromJson(jsonStr, Airport[].class);
        ArrayList<Airport> trimmedResults = new ArrayList<>();

        int limit = Integer.min(10,results.length);
        int i = 0;
        int counter = 0;
        while(i < limit && counter < results.length){
            if(results[counter].getName() != null && results[counter].getIata().toLowerCase().contains(key.toLowerCase())){
                trimmedResults.add(results[counter]);
                ++i;
            }
            counter++;
        }
        return trimmedResults;
    }

    /*public static void main(String[] args) {
        System.out.println(findAirports("BAN").get(0).getName());
    }*/
}
