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

    private void search() throws DvdDaoException{
        view.displaySearchDvdBanner();
        dao.getDVD(view.selectDVD());
    }

    private void save() throws DvdDaoException{
        dao.writeDVD();
    }

    private void editDvd() throws DvdDaoException {
        view.displayEditBanner();
        DVD edit = dao.getDVD(view.selectDVD());
        String select = view.editDVD();
        while(true) {
            switch (select.toUpperCase()) {
                case "TITLE":
                    String initial = edit.getTitle();
                    edit.setTitle(view.editChoice(select));
                    dao.removeDVD(initial);
                    dao.addDVD(edit);
                    break;
                case "DATE":
                    edit.setRelease_date(Date.valueOf(view.editChoice(select)));
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
                    edit.setRating(Double.parseDouble(view.editChoice(select)));
                    break;
                case "REVIEW":
                    edit.setReview(view.editChoice(select));
                    break;
                case "EXIT":
                    exitMessage();
                default:
                    unknownCommand();
            }
        }
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
        dao.writeDVD();
        view.displayExitBanner();
    }
}

