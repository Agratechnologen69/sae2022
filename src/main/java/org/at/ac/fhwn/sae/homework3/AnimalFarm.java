package org.at.ac.fhwn.sae.homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalFarm {
    public static void main(String[] args){
        List<Animal> AnimalList = new ArrayList();

            while(true) {
                Scanner Input = new Scanner(System.in);
                System.out.println("Was möchten sie tun:");
                System.out.println("");
                System.out.println("1. Tier hinzufügen\n" + "2. Tiere anzeigen\n" + "3. Tiere nach Art anzeigen\n" +
                        "4. Tier entfernen\n" +
                        "5. Programm beenden");
                int UserInput = Integer.parseInt(Input.next());

                if (UserInput == 1) {
                    Scanner AddAn = new Scanner(System.in);
                    System.out.println("Welche Tierart wollen Sie hinzufügen?\n");
                    printAnimalListing();
                    int AddAnimal = Integer.parseInt(AddAn.next());

                    Scanner Add = new Scanner(System.in);
                    Scanner AddNa = new Scanner(System.in);
                    System.out.println("Geben Sie einen Namen für das Tier ein:");
                    String AddName = AddNa.next();

                    if (AddAnimal == 1) {
                        AnimalList.add(new Horse(AddName));
                    } else if (AddAnimal == 2) {
                        AnimalList.add(new Cow(AddName));
                    } else if (AddAnimal == 3) {
                        AnimalList.add(new Pig(AddName));
                    } else if (AddAnimal == 4) {
                        AnimalList.add(new Chicken(AddName));
                    } else {
                        System.out.println("Bitte gib eine Zahl zwischen 1-4 ein");
                    }

                } else if (UserInput == 2) {
                    printAnimalList(AnimalList);

                } else if (UserInput == 3) {
                    Scanner AddShow = new Scanner(System.in);
                    System.out.println("Welche Tierart wollen Sie nach Art anzeigen");
                    printAnimalListing();
                    int Show = Integer.parseInt(AddShow.next());
                    printHead();
                    int counter = 1;
                    if (Show==1){
                        printHorseList(AnimalList, counter);
                    }else if (Show==2){
                        printCowList(AnimalList, counter);
                    }else if (Show==3){
                        printPigList(AnimalList, counter);
                    }else if (Show==4){
                        printChickenList(AnimalList, counter);
                    }else{
                        System.out.println("Bitte eine Nummer zwischen 1-4 eingeben");
                    }

                } else if (UserInput == 4) {
                    Scanner SelectAn = new Scanner(System.in);
                    System.out.println("Welche Tierart wollen entfernen");
                    printAnimalListing();
                    int SelectAnimal = Integer.parseInt(SelectAn.next());

                    printHead();
                    List<Integer> TempList = new ArrayList();
                    int counter = 1;
                    if (SelectAnimal==1){
                        printDeletedHorseList(AnimalList, TempList, counter);
                    }else if (SelectAnimal==2){
                        printDeletedCowList(AnimalList, TempList, counter);
                    }else if (SelectAnimal==3){
                        printDeletedPigList(AnimalList, TempList, counter);
                    }else if (SelectAnimal==4){
                        printDeletedChickenList(AnimalList, TempList, counter);
                    }else {
                        System.out.println("Bitte eine Nummer zwischen 1-4 eingeben");
                    }

                    Scanner DeleteAn = new Scanner(System.in);
                    System.out.println("Nummer des Tieres das gelöscht werden soll:");
                    int DeleteAnimal = Integer.parseInt(DeleteAn.next());

                    int temp = TempList.get(DeleteAnimal-1);
                    AnimalList.remove(temp);

                }else{
                    System.out.println("Programm beendet");
                    break;
                }
            }
        }

    private static void printHead() {
        System.out.printf("| %-6s | %-6s | %-8s %n", "Nr.", "Id",  "Name");
        System.out.println("--------------------");
    }

    private static void printAnimalListing() {
        System.out.println("1. Pferd\n" +
                "2. Kuh\n" +
                "3. Schwein\n" +
                "4. Huhn");
    }

    private static void printDeletedChickenList(List<Animal> AnimalList, List<Integer> TempList, int counter) {
        for (Animal animal: AnimalList) {
            if (animal instanceof Chicken){
                System.out.printf("| %-6s | %-6s | %-8s %n", counter, animal.getID(),  animal.name);
                counter +=1;
                TempList.add(AnimalList.indexOf(animal));
            }
        }
    }

    private static void printDeletedPigList(List<Animal> AnimalList, List<Integer> TempList, int counter) {
        for (Animal animal: AnimalList) {
            if (animal instanceof Pig) {
                System.out.printf("| %-6s | %-6s | %-8s %n", counter, animal.getID(), animal.name);
                counter +=1;
                TempList.add(AnimalList.indexOf(animal));
            }
        }
    }

    private static void printDeletedCowList(List<Animal> AnimalList, List<Integer> TempList, int counter) {
        for (Animal animal: AnimalList) {
            if (animal instanceof Cow){
                System.out.printf("| %-6s | %-6s | %-8s %n", counter, animal.getID(),  animal.name);
                counter +=1;
                TempList.add(AnimalList.indexOf(animal));
            }
        }
    }

    private static void printDeletedHorseList(List<Animal> AnimalList, List<Integer> TempList, int counter) {
        for (Animal animal: AnimalList) {
            if (animal instanceof Horse) {
                System.out.printf("| %-6s | %-6s | %-8s %n", counter, animal.getID(), animal.name);
                counter +=1;
                TempList.add(AnimalList.indexOf(animal));
            }
        }
    }

    private static void printChickenList(List<Animal> AnimalList, int counter) {
        for (Animal animal: AnimalList) {
            if (animal instanceof Chicken){
                System.out.printf("| %-6s | %-6s | %-8s %n", counter, animal.getID(),  animal.name);
                counter +=1;
            }
    }
    }

    private static void printPigList(List<Animal> AnimalList, int counter) {
        for (Animal animal: AnimalList) {
            if (animal instanceof Pig) {
                System.out.printf("| %-6s | %-6s | %-8s %n", counter, animal.getID(), animal.name);
                counter +=1;
            }
        }
    }

    private static void printCowList(List<Animal> AnimalList, int counter) {
        for (Animal animal: AnimalList) {
            if (animal instanceof Cow){
                System.out.printf("| %-6s | %-6s | %-8s %n", counter, animal.getID(),  animal.name);
                counter +=1;
            }
        }
    }

    private static void printHorseList(List<Animal> AnimalList, int counter) {
        for (Animal animal: AnimalList) {
            if (animal instanceof Horse) {
                System.out.printf("| %-6s | %-6s | %-8s %n", counter, animal.getID(), animal.name);
                counter +=1;
            }
        }
    }

    private static void printAnimalList(List<Animal> AnimalList) {
        printHead();
        for (Animal animal: AnimalList) {
            System.out.printf("| %-6s | %-6s | %-8s %n", AnimalList.indexOf(animal)+1, animal.getID(),  animal.name);
        }
    }
}
