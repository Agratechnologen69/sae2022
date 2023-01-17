package org.at.ac.fhwn.sae.location.server;

import org.at.ac.fhwn.sae.homework3.Cow;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class LocationServiceLesson {

    Hashtable<Integer, Cow> cows = new Hashtable<>();

    public void helloWorld(Cow cow, int index){
        System.out.println("Hello Worlds");
        cows.put(index,cow);
    }

    public Hashtable<Integer, Cow> getCows() {;
        return cows;
    }
}
