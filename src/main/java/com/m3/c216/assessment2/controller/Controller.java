package com.m3.c216.assessment2.controller;

import com.m3.c216.assessment2.dao.DvdDao;
import com.m3.c216.assessment2.dao.DvdDaoException;
import com.m3.c216.assessment2.dto.DVD;
import com.m3.c216.assessment2.ui.DvdView;

import java.sql.Date;
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
            do {
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
                    case "EXIT":
                        running=false;
                        continue;
                    default:
                        unknownCommand();
                }
            } while(running);
            exitMessage();

        } catch (DvdDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void search() throws DvdDaoException{
        view.displaySearchDvdBanner();
        dao.getDVD(view.selectDVD());
    }

    private void save() throws DvdDaoException{
        view.displaySavedBanner();
        dao.writeDVD();
    }

    private void editDvd() throws DvdDaoException {
        view.displayEditBanner();
        DVD edit = dao.getDVD(view.selectDVD());
        String select = view.editDVD();
        String changed;
//        boolean run=true;
//        do {
            switch (select.toUpperCase()) {
                case "TITLE":
                    String initial = edit.getTitle();
                    edit.setTitle(view.editChoice(select));
                    dao.removeDVD(initial);
                    dao.addDVD(edit);
                    break;
                case "DATE":
                    try {
                        changed = view.editChoice(select);
                        Date new_date = Date.valueOf(changed);
                        edit.setRelease_date(new_date);
                    } catch (IllegalArgumentException e) {
                        throw new DvdDaoException("Error: must enter valid date in format yyyy-mm-dd");
                    }
                    break;
                case "MPAA":
                    edit.setMpaa(view.editChoice(select));
                    break;
                case "DIRECTOR":
                    edit.setDirector(view.editChoice(select));
                    break;
                case "STUDIO":
                    edit.setStudio(view.editChoice(select));
                    break;
                case "RATING":
                    try {
                        edit.setRating(Double.parseDouble(view.editChoice(select)));
                    } catch(IllegalArgumentException e) {
                        throw new DvdDaoException("Error: must enter a rating and a comment.");
                    }
                    break;
                case "REVIEW":
                    edit.setReview(view.editChoice(select));
                    break;
                default:
                    unknownCommand();
            }
//        } while(run);
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

    private void load() throws DvdDaoException {
        view.displayLoadedBanner();
        dao.loadCollection();
    }

    private void display() throws DvdDaoException {
        view.displayDVDinfo(dao.getDVD(view.selectDVD()));
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private String GetSelection() {
        return view.printMenuAndGetSelection();
    }

    private void exitMessage() throws DvdDaoException {
        save();
        view.displayExitBanner();
    }
}

