package com.m3.c216.assessment;

import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    private static int limit=101; //100%

    public int randomiser(int n){
        Random r = new Random();
        int percentage = r.nextInt((n));
        limit -= percentage; //decreases every time function called.
        return percentage;
    }

    public static void main(String[] args) {
        DogGenetics d = new DogGenetics(); // create object to call randomiser method non-statically.
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your dog's name?");
        String name = scanner.nextLine();
        System.out.printf("%s's Esquire is: %n" +
                "%n%d St. Bernard %n%d Chihuahua %n%d Dramatic RedNosed Asian Pug %n%d Common Cur %n%d King Doberman%n" +
                        "%nWow! That's quite the dog!",
                name, d.randomiser(limit), d.randomiser(limit), d.randomiser(limit), d.randomiser(limit), limit-1);
                      //calls function which returns the percentage instead of storing it in variables.
    }
}
