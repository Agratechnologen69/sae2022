package org.at.ac.fhwn.sae.homework4;

import org.at.ac.fhwn.sae.lesson4.NmeaReaderApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NmeaReader {

    private final Scanner scanner;

    public NmeaReader(File nmeaFile){
        try {
            assert nmeaFile.exists();
            FileInputStream fis = new FileInputStream(nmeaFile);
            scanner = new Scanner(fis);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public SaePoint readPoint(){
        SaePoint saePoint = null;

        while (saePoint==null &&  scanner.hasNext()){
            String line;
            line = scanner.next();
            if(line==null){
                return null;
            }
            String[] values = line.split(",");

            if (values[0].equals("$GNGGA")){
                String time = values[1];
                double latitude = Double.parseDouble(values[2]);
                latitude = (int)latitude/100+((latitude%100)/60);
                double longitude = Double.parseDouble(values[4]);
                longitude = (int)longitude/100+((longitude%100)/60);
                int numberOfSatellites = Integer.parseInt(values[7]);
                int fix = Integer.parseInt(values[6]);
                saePoint = new SaePoint(time,latitude,longitude,numberOfSatellites,fix);
            }

        }

        return saePoint;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = getNmeaFileScanned();
        List<SaePoint> SaePointList = new ArrayList();

        while (scanner.hasNext()) {
            String[] components = scanner.nextLine().split((","));

            if (components[0].equals("$GNGGA")) {

                double latitude = Double.parseDouble(components[2]);
                latitude = (int)latitude/100+((latitude%100)/60);
                double longitude = Double.parseDouble(components[4]);
                longitude = (int)longitude/100+((longitude%100)/60);
                int numberOfSatellites = Integer.parseInt(components[7]);
                int fix = Integer.parseInt(components[6]);

                createSaePoints(SaePointList, components, latitude, longitude, numberOfSatellites, fix);
            }
        }
        printHead();
        printSaePointList(SaePointList);
    }

    /**
     * Loads and scans the given-file as Scanner
     * @return The scanner of the file
     * @throws FileNotFoundException
     */
    private static Scanner getNmeaFileScanned() throws FileNotFoundException {
        File NmeaFile = new File(NmeaReaderApplication.class.getClassLoader().getResource("auto.txt").getFile());

        FileInputStream fis = new FileInputStream(NmeaFile);
        Scanner scanner = new Scanner(fis);
        return scanner;
    }
    /**
     * Creates the Class SaePoint and adds it into the SaePointList
     * @param SaePointList The Array List to add it
     * @param components strings of every line from the scanner
     * @param latitude latitude of the line
     * @param longitude longitude of the line
     * @param numberOfSatellites number of the satellites of the line
     * @param fix fix of the line
     */
    private static void createSaePoints(List<SaePoint> SaePointList, String[] components, double latitude, double longitude, int numberOfSatellites, int fix) {
        if (components[3].equals("S")){
            latitude =-latitude;
        }
        if(components[5].equals("W")){
            longitude =-longitude;
        }
        SaePointList.add(new SaePoint(components[1], latitude, longitude, numberOfSatellites, fix));
    }
    /**
     * Prints the Head for the output
     */
    private static void printHead() {
        System.out.printf("%-12s|%-20s|%-20s|%-5s|%-3s %n", "time", "longitude", "latitude", "satNr", "fix");
    }
    /**
     * Prints the whole list from a Arraylist for the output
     * @param SaePointList The given Arraylist that gets printed
     */
    private static void printSaePointList(List<SaePoint> SaePointList) {
        for (SaePoint saePoint : SaePointList) {
            System.out.print(String.format("%-12s",saePoint.getTime()));
            System.out.print(String.format("|%-20s",saePoint.getLatitude()));
            System.out.print(String.format("|%-20s",saePoint.getLongitude()));
            System.out.print(String.format("|%-5s",saePoint.getNumberOfSatellites()));
            System.out.print(String.format("|%-3s %n",saePoint.getFix()));
        }
    }

}