package org.at.ac.fhwn.sae.location.server;

import org.at.ac.fhwn.sae.homework3.Cow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;

@RestController
public class HelloWorldController {

    LocationServiceLesson locationService;

    public HelloWorldController(LocationServiceLesson locationService){
        this.locationService = locationService;
    }

    @GetMapping("/")
    public String root(){
        return "Hello World";
    }

    @GetMapping("/cow")
    public Cow cow(@RequestParam("index") int index){
        Cow cow = new Cow("Loisi");
        locationService.helloWorld(cow,index);
        return cow;
    }

    @GetMapping("/cows")
    public Hashtable<Integer, Cow> cows(){
        return locationService.getCows();
    }


}

