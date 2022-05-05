package com.m3.c216.assessment2.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{
    private Scanner input = new Scanner(System.in);

    /**
     * Print a given String to the user.
     *
     * @param msg String to be displayed to the user.
     */
    @Override
    public void printout(String msg) {
        System.out.println(msg);
    }

    /**
     * Read in the user response as a String and return that value
     *
     * @param prompt informs the user what to input
     * @return String
     */
    @Override
    public String readString(String prompt) {
        return input.nextLine();
    }

    /**
     * If input contains rating as a float, separate float item from string
     * @param input includes date_released info
     * @return a double separated from within a string
     */
    public Double readDouble(String input){

    }

//    /**
//     * Read in user response as a double and return that value
//     *
//     * @param prompt informs the user what to input
//     * @return double
//     */
//    @Override
//    public double readDouble(String prompt, double rating) {
//        return input.nextDouble();
//    }
}
