package com.lavalliere.daniel.java;

import com.lavalliere.daniel.kotlin.MaxKt;
import com.lavalliere.daniel.kotlin.Person;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello Java");

        Person bob = new Person("Robert", "Smith");
        System.out.printf("The new employee's name is %s \n", bob.getFirstName());
        bob.setFirstName("Bob");
        System.out.printf("His name is now %s \n", bob.getFirstName());


        Integer maxint = MaxKt.Max(10, 20);
        System.out.printf("The max value between 10 and 20 is %d\n", maxint);
    }
}
