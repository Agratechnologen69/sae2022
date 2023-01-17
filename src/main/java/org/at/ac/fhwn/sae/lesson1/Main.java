package org.at.ac.fhwn.sae.lesson1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int number = 42; //this is a comment
        System.out.println(number);  // STRG + / to comment

         int constantVariable = 7 ; // select name + shift + F6 -> change the style of the name for the whole code!!

        constantVariable = 6;

        boolean result = number == constantVariable;

        System.out.println(result);

        if(number>2){
            System.out.println("number " + number + " is bigger than 2");
        }else{
            System.out.println("number " + number + " is smaller or equal 2");
        }

        double value = 56.891327450983745;
        System.out.println(String.format("value is %f %s %d",value, "Test", number));

        Scanner in = new Scanner(System.in);
        System.out.println("Enter something:");
        String input = in.next();

        System.out.println("You entered: " + input);

        double enteredValue = Double.parseDouble(input);

    }
}
