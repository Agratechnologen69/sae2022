package org.at.ac.fhwn.sae.location.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.at.ac.fhwn.sae.homework4.SaePoint;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class LocationClientService {

    private static final String REQUEST_METHOD_SET_LOCATION = "/setLocation";
    private static final String REQUEST_METHOD_GET_LOCATION = "/location";
    private static final String REQUEST_METHOD_GET_LOCATIONS = "/locations";
    private static final String REQUEST_METHOD_GET_ALL_LOCATIONS = "/allLocations";
    private static final String BASE_URL = "https://location-server-koppensteiner-location-app-api.azuremicroservices.io";


    public SaePoint sendLocation(SaePoint pointToSend, int id) {
        HttpURLConnection connection = null;

        try {
            double lat = pointToSend.getLatitude();
            double lon = pointToSend.getLongitude();
            String time = pointToSend.getTime();
            int nrOfSatellites = pointToSend.getNumberOfSatellites();
            int fixQuality = pointToSend.getFix();
            connection = (HttpURLConnection) new URL(BASE_URL+REQUEST_METHOD_SET_LOCATION+"?id="+id+ "&lat="+lat+"&lon="+lon+"&time="+time+"&satNr="+nrOfSatellites+"&fixQ="+fixQuality).openConnection();
            getResponseString(connection.getInputStream());

            return pointToSend;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public SaePoint getLocation(int id){
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL+REQUEST_METHOD_GET_LOCATION+"?id="+id).openConnection();
            String json = getResponseString(connection.getInputStream());
            SaePoint jsonPoint = new ObjectMapper().readValue(json, SaePoint.class);
            return jsonPoint;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public List<SaePoint> getLocations(int id){
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL+REQUEST_METHOD_GET_LOCATIONS+"?id="+id).openConnection();

            String jsonArray = getResponseString(connection.getInputStream());
            List<SaePoint> points = new ObjectMapper().readValue(jsonArray , new TypeReference<List<SaePoint>>(){});
            return points;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Hashtable<Integer,List<SaePoint>> getAllLocations(){

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL+REQUEST_METHOD_GET_ALL_LOCATIONS).openConnection();
            String jsonArray = getResponseString(connection.getInputStream());
            Hashtable<Integer,List<SaePoint>> allPoints = new ObjectMapper().readValue(jsonArray,new TypeReference<>(){});
            return allPoints;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getResponseString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        StringBuffer stringBuffer = new StringBuffer();
        while (scanner.hasNextLine()){
            stringBuffer.append(scanner.nextLine());
        }
        return stringBuffer.toString();
    }



}

