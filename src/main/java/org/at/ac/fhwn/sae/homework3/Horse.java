package org.at.ac.fhwn.sae.homework3;

public class Horse extends Animal {
    private static final String CLASS_DESCRIPTION="This is a horse class";
    private static int count=0;
    private String id;

    public Horse(String name){
        this.name=name;
        this.id="H"+ ++count;
    }


    public String getID() {
        return id;
    }
    public static int getCount(){
        return count;
    }
}
