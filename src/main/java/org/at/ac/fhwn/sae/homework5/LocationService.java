package org.at.ac.fhwn.sae.homework5;

import org.at.ac.fhwn.sae.homework4.SaePoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Service
public class LocationService {

    Hashtable<Integer,List<SaePoint>> saePoints = new Hashtable<>();

    public void addLocation(int id, SaePoint location) {
        if(saePoints.containsKey(id)){
            saePoints.get(id).add(location);
        }else{
            saePoints.put(id,new ArrayList<>());
            saePoints.get(id).add(location);
        }
    }

    public SaePoint getLocation(int id, int index) {
        return saePoints.get(id).get((saePoints.get(id).size()-1)-index);
    }

    public List<SaePoint> getLocations(int id) {
        return saePoints.get(id);
    }

    public Hashtable<Integer, List<SaePoint>> getAllLocations(){
        return saePoints;
    }


}
