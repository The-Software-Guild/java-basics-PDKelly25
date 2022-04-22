package com.m3.c216.assessment;

import java.util.Scanner;

public class HealthyHearts {
    private int max;
    private int zoneLB; //lower bound
    private int zoneHB; //higher bound

    public HealthyHearts(int input){
        max = 220 - input;
        zoneLB = (int) Math.round(0.5 * max); //round to nearest integer ()
        zoneHB = (int) Math.round(0.85 * max);
        printout(max, zoneLB, zoneHB);
    }

    public void printout(int max, int zoneLB, int zoneHB){
        System.out.printf("Your maximum heart rate should be %d beats per minute%n" +
                "Your target HR Zone is %d - %d beats per minute", max, zoneLB, zoneHB);
    }

    public static void main(String[] args) {
        System.out.println("What is your age?");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        new HealthyHearts(input);
    }
}
