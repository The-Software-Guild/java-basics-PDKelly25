package com.m3.c216.assessment2.controller;

import com.m3.c216.assessment2.dao.DvdDao;
import com.m3.c216.assessment2.dao.DvdDaoException;
import com.m3.c216.assessment2.dto.DVD;
import com.m3.c216.assessment2.ui.DvdView;

import java.util.List;

public class Controller {

    private DvdDao dao;
    private DvdView view;
//    private UserIO io = new UserIOConsoleImpl();

    public Controller(DvdDao dao, DvdView view){
        this.dao = dao;
        this.view = view;
    }

    public void run(){
        String menuSelection;
        boolean running = true;
        try {
            while(running) {
                menuSelection = GetSelection();
                switch (menuSelection.toUpperCase()) {
                    case "ADD":
                        addDvd();
                        break;
                    case "REMOVE":
                        removeDvd();
                        break;
                    case "EDIT":
                        editDvd();
                        break;
                    case "LIST":
                        listDVDs();
                        break;
                    case "DISPLAY":
                        display();
                        break;
                    case "SEARCH":
                        search();
                        break;
                    case "LOAD":
                        load();
                        break;
                    case "SAVE":
                        save();
                        break;
                    case "EXIT":
                        exitMessage();
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();

        } catch (DvdDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void editDvd() {

    }

    private void addDvd() throws DvdDaoException {
        view.displayCreateDvdBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD);
        view.displayCreateSuccessBanner();
    }

    private void removeDvd() throws DvdDaoException {
        view.displayRemoveDvdBanner();
        String title = view.selectDVD();
        DVD removed = dao.removeDVD(title);
        view.displayRemoveResult(removed);
    }

    private void listDVDs() throws DvdDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void load(){

    }

    private void display() {

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private String GetSelection() {
        return view.printMenuAndGetSelection();
    }

    private void exitMessage() throws DvdDaoException {
        dao.writeDVD();
        view.displayExitBanner();
    }
}

