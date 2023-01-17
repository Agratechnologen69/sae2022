package org.at.ac.fhwn.sae.lesson4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NmeaReaderApplication {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(NmeaReaderApplication.class.getClassLoader().getResource("nmea.txt").getFile());

        System.out.println("Exists: "+ file.exists());
        System.out.println("Can read:"+ file.canRead());

        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);

        while(scanner.hasNext()){
            //System.out.println(scanner.nextLine());
            // NUR GNGGA BEHANDELN

            String[] componentns = scanner.nextLine().split((","));

            if(componentns[0].equals("$GNGGA")){ // STRING VERGLEICHE MIT EQUALS -> ANSONSTEN VERGLEICHEN WIR INSTANZEN
                //componentns[0].endsWith("GGA");  // replace gibts a
                System.out.println("FOUND");
            }
        }


    }
}
