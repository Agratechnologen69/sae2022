package org.at.ac.fhwn.sae.homework3;

public abstract class Animal {
    protected String name;
    protected int number;
    protected static final String DEFAULT_ID = "0";
    protected static final Integer DEFAULT_NUMBER = 0;

    public abstract String getID();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
