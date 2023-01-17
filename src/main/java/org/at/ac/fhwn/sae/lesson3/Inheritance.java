package org.at.ac.fhwn.sae.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Inheritance {
    public static void main(String[] args){
        Dog dog = new Dog("Rex");
        Dog noNameDog = new Dog();
        dog.setName("Hugo");
        System.out.println(dog.getName().charAt(0));
        System.out.println(noNameDog.getName());
        System.out.println(dog.getCount()+"dogs are created");

        Cat cat = new Cat();
        System.out.println(cat.getName());

        dog.bark();
        createDog();

        List<Animal> list = new ArrayList();
        list.add(noNameDog);
        list.add(cat);
        list.add(dog);

        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).getName());
        }
        for(Animal animal:list){
            System.out.println(animal.name);
            if(animal instanceof Dog){
                ((Dog) animal).bark();
            }
        }

        //System.out.println(list.get(2).getName());


        Person p = buildPerson(42,"Karl");

    }
    static void createDog(){

    }
    static Person buildPerson(int number, String name){
        return new Person(number,name);
    }
}
