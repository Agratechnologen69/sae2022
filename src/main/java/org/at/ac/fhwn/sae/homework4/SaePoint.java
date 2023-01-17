package org.at.ac.fhwn.sae.homework4;

import java.io.PrintStream;

public class SaePoint {
    private  String time;
    private  double latitude;
    private  double longitude;
    private  int numberOfSatellites;
    private  int fix;

    public SaePoint(){

    }

    public SaePoint(String time, double latitude, double longitude, int numberOfSatellites, int fix){
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numberOfSatellites = numberOfSatellites;
        this.fix = fix;
    }


    public  String getTime() {
        return time;
    }

    public  double getLatitude() {
        return latitude;
    }

    public  double getLongitude() {
        return longitude;
    }

    public  int getNumberOfSatellites() {
        return numberOfSatellites;
    }

    public  int getFix() {
        return fix;
    }

    public String makeString() {
        return String.format("| %-10s | %-20s | %-20s | %-7s | %-5s %n", time, latitude,longitude,numberOfSatellites,fix);

    }
}
