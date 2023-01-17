package org.at.ac.fhwn.sae.lesson3;

public abstract class Animal {
    protected String name; //protected for subclasses! private only for the class
    protected static final String DEFAULT_ID = "0";

    //public Animal (String name){
    //    this.name = name;
    //}
    public abstract String getID();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
