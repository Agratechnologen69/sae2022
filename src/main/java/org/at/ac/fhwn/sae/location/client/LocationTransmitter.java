package org.at.ac.fhwn.sae.location.client;

import org.at.ac.fhwn.sae.homework4.NmeaReader;
import org.at.ac.fhwn.sae.homework4.SaePoint;
import org.at.ac.fhwn.sae.lesson4.NmeaReaderApplication;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class LocationTransmitter {

    public static void main(String[] args) {

        File file = new File(NmeaReaderApplication.class.getClassLoader().getResource("auto.txt").getFile());

        NmeaReader nmeaReader = new NmeaReader(file);
        LocationClientService clientService = new LocationClientService();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                SaePoint saePoint = nmeaReader.readPoint();
                //System.out.println("Time: "+ new Date());
                System.out.println(clientService.sendLocation(saePoint,2).makeString());

            }
        };

        Timer timer = new Timer("timerTask");

        timer.scheduleAtFixedRate(timerTask,1000,1000);

        //nmeaReader.getNextPosition();

    }
}
