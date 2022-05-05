package com.m3.c216.assessment2.dao;

import com.m3.c216.assessment2.dto.DVD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DvdDaoImpl implements DvdDao {

    private final Map<String, DVD> dvdMap; //<K = title, V = dvd>

    public DvdDaoImpl(){
        dvdMap = new HashMap<>();
    }

    @Override
    public void addDVD(DVD dvd) {
        //throw new UnsupportedOperationException("Not supported yet.");
        dvdMap.put(dvd.getTitle(), dvd);
    }

    @Override
    public void removeDVD(DVD dvd) {
        //throw new UnsupportedOperationException("Not supported yet.");
        dvdMap.remove(dvd.getTitle()); //title is key
    }

    @Override
    public DVD getDVD(DVD dvd) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return dvdMap.get(dvd.getTitle());
    }

    @Override
    public List<DVD> getAllDVDs() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void loadDVD() {

    }

    @Override
    public void saveDVD() {

    }
}
