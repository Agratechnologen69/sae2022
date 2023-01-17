package org.at.ac.fhwn.sae.lesson1;

import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] agrs){
        System.out.println("** BMI CALCULATOR **");

        Scanner InputHeight = new Scanner(System.in);
        System.out.println("Please enter your current height in cm:");
        String height = InputHeight.next();
        double enteredHeight = Double.parseDouble(height);

        Scanner InputWeight = new Scanner(System.in);
        System.out.println("Please enter your current weight in kg:");
        String weight = InputWeight.next();
        double enteredWeight = Double.parseDouble(weight);

        double BMI = enteredWeight/(Math.pow((enteredHeight/100),2));

        System.out.println("Your BMI is: "+ String.format("%.2f",BMI));

        if (BMI<=18.4){
            System.out.println("You are underweighted");
        }else if (18.5<=BMI && BMI<=29.9){
            System.out.println("Normal Weight");
        }else if (25<=BMI && BMI<=29.9){
            System.out.println("You are slightly overweighted");
        }else if (30<=BMI && BMI<=34.9){
            System.out.println("You are overweighted");
        }else if (35<=BMI && BMI<=39.9) {
            System.out.println("You are strongly overweighted");
        }else{
            System.out.println("You are brutally overweighted, call a doctor");
        }

    }
}
