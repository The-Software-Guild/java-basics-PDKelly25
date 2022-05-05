package com.m3.c216.assessment2.ui;

import com.m3.c216.assessment2.dto.DVD;

import java.util.Date;

public class DvdView {
    private UserIO io;

    

    public String printMenuAndGetSelection() {
        io.printout("Please select an option below:");
        io.printout("ADD - to add a DVD to the collection." +
                "\nREMOVE - to remove a DVD from the collection." +
                "\nEDIT - to edit a DVD in the collection." +
                "\nLIST - to list the current DVDs in the collection." +
                "\nDISPLAY - to display info about a DVD in the collection" +
                "\nSEARCH - to search for a DVD in the collection" +
                "\nLOAD - to load a DVD from the collection." +
                "\nSAVE - to save a DVD back into the collection.");

        return io.readString("User Input: ");
    }

    //Date release_date, String mpaa, String director, String studio, String rating

    public DVD getNewDVDInfo() {
        return null;
    }
}
