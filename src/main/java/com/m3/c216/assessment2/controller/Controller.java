package com.m3.c216.assessment2.controller;

import com.m3.c216.assessment2.dao.DvdDao;
import com.m3.c216.assessment2.dao.DvdDaoImpl;
import com.m3.c216.assessment2.ui.DvdView;
import com.m3.c216.assessment2.ui.UserIO;
import com.m3.c216.assessment2.ui.UserIOConsoleImpl;

import java.util.Locale;

public class Controller {

    private DvdDao dao = new DvdDaoImpl();
    private UserIO io = new UserIOConsoleImpl();
    private DvdView view = new DvdView();

    public Controller(DvdDao dao, DvdView view){
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        String menuSelection;
        while (true) {
            io.printout("Please select an option below:");
            io.printout("ADD - to add a DVD to the collection." +
                    "\nREMOVE - to remove a DVD from the collection." +
                    "\nEDIT - to edit a DVD in the collection." +
                    "\nLIST - to list the current DVDs in the collection." +
                    "\nDISPLAY - to display info about a DVD in the collection" +
                    "\nSEARCH - to search for a DVD in the collection" +
                    "\nLOAD - to load a DVD from the collection." +
                    "\nSAVE - to save a DVD back into the collection." +
                    "\nEXIT - to exit the program.");

            menuSelection = GetSelection();

            switch (menuSelection.toUpperCase()) {
                case "ADD":
                    io.printout("Add DVD");
                    break;
                case "REMOVE":
                    io.printout("Remove DVD");
                    break;
                case "EDIT":
                    io.printout("Edit DVD");
                    break;
                case "LIST":
                    io.printout("List DVDs");
                    break;
                case "DISPLAY":
                    io.printout("Display info");
                    break;
                case "SEARCH":
                    io.printout("Search for DVD");
                    break;
                case "LOAD":
                    io.printout("Load DVD from file");
                    break;
                case "SAVE":
                    io.printout("Save DVD to file");
                    break;
                case "EXIT":
                    io.printout("GOOD BYE");
                    break;
                default:
                    io.printout("UNKNOWN COMMAND");
            }

        }
    }
    private String GetSelection() {
        return view.printMenuAndGetSelection();
    }
}

