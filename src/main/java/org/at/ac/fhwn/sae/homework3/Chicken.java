package org.at.ac.fhwn.sae.homework3;

public class Chicken extends Animal{
    private static final String CLASS_DESCRIPTION="This is a chicken class";
    private static int count=0;
    private String id;

    public Chicken(String name){
        this.name=name;
        this.id="C"+ ++count;
    }


    public String getID() {
        return id;
    }
    public static int getCount(){
        return count;
    }
}
