package com.m3.c216.assessment2.ui;

import com.m3.c216.assessment2.dto.DVD;

import java.sql.Date;
import java.util.List;

public class DvdView {
    private UserIO io;

    public DvdView(UserIO io){
        this.io = io;
    }

    public String selectDVD(){
        return io.readString("Please enter the DVD Name.");
    }

    public void displayCreateDvdBanner() {
        io.printout("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created. Please hit enter to continue");
    }

    public void displayErrorMessage(String errorMsg) {
        io.printout("=== ERROR ===");
        io.printout(errorMsg);
    }

    public void displayRemoveDvdBanner() {
        io.printout("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dvd) {
        if(dvd != null){
            io.printout("DVD successfully removed.");
        }else{
            io.printout("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

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

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.printout(String.format("%n%s %n%s %n%s %n%s %n%s %n%f %n%s",
                    currentDVD.getTitle(), currentDVD.getRelease_date(), currentDVD.getMpaa(),
                    currentDVD.getDirector(), currentDVD.getStudio(), currentDVD.getRating(), currentDVD.getReview()));
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.printout("=== Display All DVDs ===");
    }

    public void displayUnknownCommandBanner(){
        io.printout("=== Unknown Command ===");
    }

    public void displayExitBanner(){
        io.printout("=== Goodbye! ===");
    }

    public String editDVD(){
        io.printout("Please select an option below:");
        io.printout("ADD - to add a DVD to the collection." +
                "\nTITLE - to remove a DVD from the collection." +
                "\nRELEASE - to edit a DVD in the collection." +
                "\nMPAA - to list the current DVDs in the collection." +
                "\nDIRECTOR - to display info about a DVD in the collection" +
                "\nSTUDIO - to search for a DVD in the collection" +
                "\nREVIEW - to load a DVD from the collection." +
                "\nSAVE - to save a DVD back into the collection.");
        return io.readString("User Input: ");
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter DVD title");
        String release = io.readString("Please enter DVD release date in format: dd-mm-yyyy");
        String mpaa = io.readString("Please enter the MPAA of this DVD");
        String director = io.readString("Please enter the director of the DVD");
        String studio = io.readString("Please enter the studio that produced this DVD");
        String feedback = io.readString("Please give a rating out of 10 (e.g. 6.5) and a comment on the DVD");
        DVD currentDVD = new DVD(title, Date.valueOf(release), mpaa, director, studio,
                Double.parseDouble(feedback.split("(?i)(?=[a-z])",1).toString()),
                feedback.split("(?i)(?=[a-z])",2).toString());
        return currentDVD;
    }
}
