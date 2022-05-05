package com.m3.c216.assessment2.ui;


public interface UserIO {
        /**
         * Print a given String to the user.
         * @param msg String to be displayed to the user.
         */
        public void printout(String msg);

        /**
         * Read in the user response as a String and return that value
         * @param prompt informs the user what to input
         * @return String
         */
        public String readString(String prompt);
//
//        /**
//         * Read in user response as a double and return that value
//         * @param prompt informs the user what to input
//         * @return double
//         */
//        public double readDouble(String prompt, double rating);
}

