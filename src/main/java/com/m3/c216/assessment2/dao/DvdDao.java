package com.m3.c216.assessment2.dao;

import com.m3.c216.assessment2.dto.DVD;

import java.util.List;

public interface DvdDao{
    public void addDVD(DVD dvd);
    public void removeDVD(DVD dvd);
    public DVD getDVD(DVD dvd);
    public List<DVD> getAllDVDs();
    public void loadDVD();
    public void saveDVD();
}
