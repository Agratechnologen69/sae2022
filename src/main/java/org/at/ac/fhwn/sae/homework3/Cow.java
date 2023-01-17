package org.at.ac.fhwn.sae.homework3;

public class Cow extends Animal{
    private static final String CLASS_DESCRIPTION="This is a cow class";
    private static int count=0;
    private String id;

    public Cow(String name){
        this.name=name;
        this.id="C"+ ++count;
    }


    public String getID() {
        return id;
    }
}
