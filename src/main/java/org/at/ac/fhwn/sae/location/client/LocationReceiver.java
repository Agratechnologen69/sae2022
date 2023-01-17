package org.at.ac.fhwn.sae.location.client;

import org.at.ac.fhwn.sae.homework4.SaePoint;

import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LocationReceiver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LocationClientService clientService = new LocationClientService();
        boolean exit = false;

        while (exit==false){
            System.out.println("Was wollen Sie abfragen?\n" +
                    "1. Letzte Position mit id\n" +
                    "2. Positionen mit id\n" +
                    "3. Alle Positionen\n" +
                    "4. Programm schließen");

            int UserInput = in.nextInt();

            switch (UserInput){
                case 1:
                    System.out.println("Bitte ID eingeben: ");
                    SaePoint position =clientService.getLocation(in.nextInt());
                    printHead();
                    System.out.println(position.makeString());
                    break;

                case 2:
                    System.out.println("Bitte ID eingeben: ");
                    List<SaePoint> positions=clientService.getLocations(in.nextInt());
                    printHead();
                    for(int i=0;i<positions.size();i++){
                        System.out.println(positions.get(i).makeString());
                    }

                    break;
                case 3:
                    Hashtable<Integer,List<SaePoint>> allPositions = clientService.getAllLocations();
                    Set<Integer> keys = allPositions.keySet();
                    printHead2();
                    for(int key : keys){
                        for(int i=0;i<allPositions.get(key).size();i++){
                            System.out.println(key+": "+allPositions.get(key).get(i).makeString());
                        }
                    }
                    break;
                case 4:
                    exit=true;
                    break;
            }


        }

    }

    private static void printHead2() {
        System.out.printf("ID |"+" %-10s | %-20s | %-20s | %-7s | %-5s %n", "time", "latitude", "longitude", "satNr", "fix");
    }

    private static void printHead() {
        System.out.printf("| %-10s | %-20s | %-20s | %-7s | %-5s %n", "time", "latitude", "longitude", "satNr", "fix");
    }


}
